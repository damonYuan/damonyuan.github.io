Quick Start Guide
=================
The HSM application maybe set up in test mode using the online Thales HSM.
This can then be used with the MPI python test scripts.
To setup the application in test mode the following commands should be used:

make sure libssl-dev is installed.

1. Create certificate signing requests:
./hsm-server -c key-sign-dev.crt -k (v5)
./hsm-server -c Test-Miura-RKI-CA-V6.crt (v6)

2. Create BDKs:
./hsm-server -b

3. Import Miura CA key:
For SRED only use:
./hsm-server -g -k (v5)
./hsm-server -g
For SRED and online PIN use:
./hsm-server -p -k (v5)
./hsm-server -p

Send the resulting files: certs/hsm.csr and certs/hsm-v6.csr to Miura systems for signing.
Miura will return hsm.crt and hsm-v6.crt which need to be placed in your certs directory.

---------------------------------------------------


HSM Server Example Version 2-1
==============================

Part No: M000-HSMSDK-V2-1
Release date: 2013-03-22
Release file: M000-HSMSDK-V2-1.tar.gz

Introduction
============
This example is provided to show how to use a Thales PayShield 9000 HSM to provide cryptographic keys and functions for use with a Miura terminal.
The example is set up to run through the whole process of loading keys on to a Miura terminal for data encryption using DUKPT.
The full process of loading keys onto a terminal is explained in detail in the document M000-RKI-V2-X.pdf. This may be obtained from Miura Systems.
This document is intended to give an explanation of how to use this example application in conjunction with the Miura remote key loading process.
There are a number of steps involved in this process these are detailed in the rest of this document.

Building the applications
=========================
The applications in this package are desgined to be built on a Linux system.
They rely on the openssl development library being installed.
To build run make in the hsm-server directory.

Development and Production key-chains
=====================================
There are two sets of certificates which are used by Miura systems, development and production. 
For a system with terminals in use in live payment applications the production key-chain is used. 
For test and development purposes the development key-chain is used. 
The data is provided with this example to setup the development key-chain.

Setting up the Thales HSM
=========================
See also the manuals which came with the HSM. Additionally a specific version of software is need from Thales which allows the export of a DUKPT IPEK under a terminal master key (TMK). 
These features are included in custom firmware version 1343.0900.0001, but will be incorporated into a main-stream release in due course (contact your Thales representative).

A number of settings on the HSM are needed for this process to work. 
Under the configure security command  (cs) there is a setting called "Enforce key type 002 separation for PCI HSM compliance". This should be set to yes.

The setting "Restrict Key Check Values to 6 hex chars:" under the cs command should be set to yes.

The HSM should be set up to allow persistent multiple authorised activities under the cs command. 
The following activity needs to be allowed for the whole time the HSM is in use:
a export.302.host:p

The following activities need to be authorised when setting up the HSM and the hsm-server software:
a generate.rsa.host:p
a import.rsa.host:p

These should be de-authorised after the HSM and the software have been configured correctly with the c command as follows:
c generate.rsa.host:p
c import.rsa.host:p

Setting up the hsm-server application
=====================================
Before the application can be used to inject keys into a Miura terminal it must first be set-up to work with the Miura key chain.
There are 3 steps involved in this process. These both require that the above activities are authorized on the HSM.

Step 1: Import the Miura Key-signing certificate.
The certificate can be obtained from Miura Systems. 
This can then be imported for use by running the following command:
./hsm-server -c Miura-RKI-CA.crt
where "Miura-RKI-CA.crt" is the name of the Miura CA certificate for remote key injection.

Step 2: Generate a certificate for the HSM which is trusted by Miura terminals.
This involves the HSM generating a public and private RSA key pair, then generating a certificate signing request from this key pair. 
The certificate signing request then needs to be signed by the Miura PSP Signing tool. 
Firstly fill in the company details in the file hsm-cert.cfg in the root dorectory.
Then certificate signing request can be generated as follows:
./hsm-server -g
The resulting certificate signing request will then be: ./certs/hsm-v6.csr and the fingerprint will be displayed.
The file hsm-v6.crt should then be generated using the Miura PSP signing tool and placed in the certs directory. 
If you do not have access to this tool please contact Miura Systems.
The person using the tool must guarantee that the hsm-v6.csr file they are signing is authentic. 
This can be done by comparing the fingerprint with the one originally generated.

NOTE: If the system will be handling encrypted PIN blocks in on-line PIN transactions the hsm-v6.csr should be generated 
using the command:
./hsm-server -p
If this is used, the system used to do the key injection and PIN processing must be PCI PIN compliant.

Step 3: Generation of the BDKs
As in any DUKPT system, the BDKs are required for generation of the initial keys and decryption of the data.
This example uses one BDK for PIN blocks and one BDK for SRED.
These can be generated by the HSM using the command:
./hsm-server -b
They will be stored as ./certs/pin-bdk.lmk and ./certs/sred-bdk.lmk and used in the key injection process.

The HSM is now set up for use and the two additional authorised activities can be canceled.

Injecting keys into a Miura terminal.
=====================================
The hsm-server application needs a number of files from the terminal in order to complete the injection process. 
These files should be placed in an empty directory and the directory should be supplied to the hsm-server application as follows:
./hsm-server -f <dir>
where <dir> is the path to the files supplied by the terminal.
When this process is complete the generated keys will be created in this directory, all of these files should then be sent back to the terminal for installation.
An example of how to install these keys on a terminal is given in the remote-key-load example in the Miura SDK.

1. put hsm.crt and hsm-v6.crt(which should already signed by miura) in be placed in your certs directory.
   Note: once the hsm-v6.crt is signed, never to run
   $ ./hsm-server -g
   again. !will lead to the signed hsm-v6.crt invalid.

2. pin-bdk.lmk sred-bdk.lmk by 
   $ ./hsm-server -b

/*** Do not regenerate the above 4 files if they are ready! ***/

4. run P2PE_KeyInjection_test.py to inject key.(The device’s file will automatically retrieved by this function and work with the 4 files above ->generate 7 files and put them back to miura device).


Things to add to the existing application
=========================================
Currently the application is set-up to generate 2 DUKPT (Derived Unique Key Per Transaction) IPEKs (Initial PIN Encryption Keys). 
This scheme requires that each terminal be given a unique identifier called a Key Serial Number (KSN). 
This is outlined in the DUKPT specification (ANSI X9.24 part 1). 
In this example the suggested-iksn from the terminal is used and a BDK identifier is added to this.
This is then used to generate the IPEKs for the terminal.
The BDK identifier should be managed appropriately, depending on the deployment.

The ip address of the HSM is currently set using a file called hsm-ip-address.
This is set to talk to a test HSM which has been setup by Thales.
This will need to be update to address the correct HSM once the testing/development stage is complete.

Aspects of this implementation may not be suitable for inclusion in a multi-threaded application.
Care should be taken when using this code in any 3rd party application.

New key chain for Miura V6 OS
=============================
Terminals using Miura OS V5 and V6 use different key chains. This application is set to use the new V6 Miura key chain by default.
However if this implementation needs to support both v5 and v6 Miura OS this can be achiveved by creating a new hsm certificate with addtional -k option and re importing the old key-signing certificate with the -k option. The V5 and V6 key injection requests can then be carried out by the same server.
Addtionally this application is backwardly compatible with V5 key chain. 
Therefore if an implementation exists and is using the V5 key chain the applications can be updated with the latest version and rebuilt and the set up will not beed to be carried out again.

Test tools
==========

A set of test data has been supplied in the folder test-terminal. 
These files can be expected from a typical terminal.
These files are part of the Test/Development key-chain and will not work with a production terminal.

Also provided are 2 extra applications:
dukpt-dec: 	This application can be used to decrypt data encrypted by a terminal.
		This currently only supports decryption of SRED data, not online PIN blocks.
		Run ./dukpt-dec -h for a list of options

hsm-test:	This application can be used to inject known BDK and TMKs into the test Thales HSM.
		To use the BKD file produced rename and copy it over the exiting BDK files in the certs folder.
		To use the TMK provide the generated TMK file using the -t argument to the hsm-server application when performing the key injection.
		It can also decrypt TR31 blocks, giving the value of the DUKPT key which will be injected into the terminal as the initial key.
		Run ./hsm-test -h for a list of options.
Both of these applications are built using the default make command.

Additionally 2 development Miura CA certificates are supplied: Test-Miura-RKI-CA-key.crt (OS V6 key chain) and key-sign-dev.crt (OS V5 key chain) for test and development purposes.
When running the in test mode the HSM certificate request should be sent to Miura to be procesed. 
The PSP signing tool should not be used for this process as it is intended for production use only.

Fixes:
======
Bug#1248	HSM server example produces corrupt IKSN

Enhancments:
============
Bug#1368	Update HSM server example to support V5 and V6 keychains
Bug#1396	Ability to change IP address in the HSM server example.
Bug#1397	Add a test facility to hsm-server example
Bug#1420	Change to hsm-server example to output decrypted data format

Known Issues:
=============
Online PIN block decrypt not supported.


