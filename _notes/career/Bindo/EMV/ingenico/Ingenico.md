ingenico
==============

ingenico
--- Docs3 -> RBA_SDK Documents
|
--- 

#1. jason.ngan@bindo.com/DdqrrI90rVYp

#2. Ethernet settings 

#3. reboot iPP350
    1. Local Loading Tool (LLT)
    2. A short tutorila video to set up everything for LLT properly (LLT_JUNGO_Win7)
    3. IngenicoUSBDrivers_2.40_setup.exe (Jungo)

    Note:
    LLT Software runs under platforms
    - Windows XP(32 bits)
    - Windows Vista(32 and 64 bits)
    - Windows Seven(32 and 64 bits)

#4. iCMP
    1. connect: function -> select iOS mode -> Pair

#5. EMV not support? if support, should we host a HSM.

#6. On Line -> swipe card -> "Please wait for the cashier" -> what is the next action? 
    https://www.dropbox.com/s/1ylmxvq829tez0x/IMG_0082.MOV?dl=0

#7. reboot and select the right communication type.
    When the version screen shown
    : 2634 Green key + F F + TDA + Green key * 3
    A “How to Change Communication Setting” document is attached. Just treat the iCMP just like an iSMP in the documentation.
    (Normally unpair a device is to press the F four times)

#8. EMV
    2_1 Card Detection
        1. Transactions are initiated when the ECR sends the “14.01” Set Transaction Type message to the PIN pad device.
        2. If EMV is enabled in the configuration file, then subsequent transactions will be configured EMV transactions each time the application enters the online idle state.
        3. As a note, the first digit of the service code for EMV cards will be ‘2’ or ‘6’ with the BIN range indicating that EMV transactions are supported.
    2_2 Language Selection
        1. The supported language list is provided in the EMVCONTACT.XML file ICS parameters. Languages are defined in tag 0x9F8431.

    2_3 Application Selection
        The Canadian Application Selection flag process requirement has been incorporated to facilitate compliance with Interac Direct Payment (IDP) specifications, the national EMV specifications for Canada.

        The user of the application may activate or deactivate the application selection for Interac Application Selection and Domestic VISA Debit. This feature is controlled by two parameters in the EMV.DTA file:

          * Interac Application Selection Flag (ASF) '0019_0007'.
          * Domestic VISA Debit Application Selection Flag '0019_0008'.

        A “0” value indicates that the corresponding application selection will be disabled while a “1” value indicates that the application selection will be enabled.

    2_4 Read Application Data
        Application File Locator (AFL)
        An Application File Locator (AFL) is read from the card and is used by the PIN pad device to read data records from the card which are required for the transaction (e.g., card verification method list, Track 2 equivalent data). The PIN pad retrieves the information and then sends it to the ECR using a “33.02” response message.

    2_5 Data Authentication
         static Data Authentication (SDA), Dynamic Data Authentication (DDA), 
         While both SDA and DDA methods protect against modification, the DDA method provides protection from cloning.

    2_6 Cardholder Verification
        Cardholder Verification Methods (CVMs) is stored on the EMV card. 
        1 PIN Entry
          In the offline mode, PIN verification is performed by the card, whereas in the online mode PIN verification is performed by card issuer. 

          Online PIN entry requires that a PIN session key is loaded into the secret area. The PIN key index and encryption method are retrieved from the PIN.DAT parameter file. 

        2 Signature Management
          CARDS.DAT
          The RBA application locad the form of signature and awaits cardholder entry. -> ??

        3 EMV Reversal
          
        4 EMV Fallback
          PAN on track2: Primary Account Number
          1. The card chip malfunctioned at the start of the transaction.
              the RBA sends a “33.01” Status message to inform the ECR of the chip malfunction. 
              The RBA then sends a “33.05” Authorization Confirmation message to terminate the EMV transaction.The ECR decides whether or not fallback is allowed.
          2. Other card chip related problems occurred during the transaction.
          3. There are problems which are unrelated to the card, such as a MasterCard stipulation that requires fallback if the PAN within Track 2 differs from the actual PAN.
             the RBA sends a “33.02” Track 2 Equivalent Data message. EMV tags encoded in the message inform the ECR of the potential problems. The ECR then decides whether or not fallback is necessary.

          the ECR should allow the swipe of a chip card for once (since the ECR is doing the check of the service code to verify if the swiped card is an EMV chip card or not).

    2_7 Terminal Risk Management
        The authorization should be offline or online.
        The amount of the transaction is compared to an offline limit. If this limit is exceeded, then online authorization is required.

    2_8 Terminal Actin Analysis (whether or not to proceed with the transaction)
          Issuer Action Codes (IACs) Terminal Action Codes (TACs) cofigured for each AID in the EMVCONTACT.XML and EMVCLESS.XML configure files.

    2_9 First Card Action Analysis
        The PIN pad device sends this tag data and then requests a cryptogram from the card based on its decision as to how to proceed with the authorization.

    2_10 online Transaction Authorization
    2_11 Second Card Action Analysis
    2_12 Once the transaction is completed, the PIN pad device send a '10.' hard reset message to the ECR indicating that it is returning to the online idle state and awaits the next transaction.

    3_Host Interface Messages
      When a transaction is being processed as an EMV transaction, communication messages between the PIN pad device and the ECR are uniquely identified by a “33." message identifier.
    
    4_Emv Transaction Flow
      It should be noted that every time the application enters the online idle state it immediately configures the next transaction to be an EMV purchase transaction if EMV is enabled in the configuration file. 

    4_3 EMV Refund Transaction Flow
        EMV refund transactions are processed for cards which fully support EMV transactions. At this time, only Interac cards meet this criteria. 

        In order to initiate an EMV refund transaction, the ECR must communicate to the PIN pad device that EMV transactions are fully supported. This is accomplished by setting the appropriate flag in the configuration file.

    4_5 Non-EMV Refund Transaction Flow
        Non-EMV refund transactions are implemented for cards which do not support full EMV refund transactions. Currently, all embedded chip credit card transactions follow this flow. In order to initiate a non-EMV refund transaction, the ECR must first indicate to the PIN pad device that the ECR supports EMV transactions. This is accomplished by configuring the appropriate flag in the configuration file.

        The following are examples of card issuers which fall into this category:
        * VISA
        * MasterCard
        * Discover
        * American Express

    4_6 Non-EMV Tag Definitions
        



#9. LLT mode
    reboot -> hld the F3 "up" arrow key.

#10. Reload the device:
     when see the smile face:
     Press F1 F4 F2 F3 then
     go to the PC which connected with ingenico through usb -> goto PK-RGEN02-1202B3 folder -> open file in load script -> This is a two-step installation, when finishing the first time, should reboot to LLT mode, then continue.

     THEN you will enter KEY INJECTION SCREEN, because the key has already been injected by authorized facility, just select NO KEY INJECTION -> YES

#11. see if the key is injected
     DUKPT KEY 

     2634 + F F -> TSA -> DUKPT KSN -> DUKPT0

#12. ??? Once set to DHCP will enter "Waiting for download..." ???
      Regarding the Waiting For Download error, I have confirmed that is a minor bug.
      When that happens, hit the Cancel key repeatedly until you get the option to hit “F” to enter to Functions Menu.

#13. BIN -> Bank Identification Number

#14. You cannot send Online message to the device right after it is connected: Device is connected, but not ready.

#15. Connect and Reconnect: do status
     2015-02-09 15:59:02.548 RBA_SDK_Demo[5065:1438809] <2015-02-09 15:59:02.547> [INFO ]:RBA_SDK: Application called Connect ...
     2015-02-09 15:59:02.551 RBA_SDK_Demo[5065:1438809] <2015-02-09 15:59:02.551> [DEBUG]:RBA_SDK: UpdateCommunicationSettings::delete comm module
     2015-02-09 15:59:02.554 RBA_SDK_Demo[5065:1438809] <2015-02-09 15:59:02.554> [INFO ]:RBANetworkDevice: Connecting ...
     2015-02-09 15:59:02.860 RBA_SDK_Demo[5065:1438809] <2015-02-09 15:59:02.860> [INFO ]:RBANetworkDevice: Connected to 192.168.1.111:12000
     2015-02-09 15:59:02.864 RBA_SDK_Demo[5065:1438809] <2015-02-09 15:59:02.863> [DEBUG]:RBA_SDK: --> StartThreadDoStatus
     2015-02-09 15:59:02.867 RBA_SDK_Demo[5065:1438809] <2015-02-09 15:59:02.866> [DEBUG]:RBA_SDK: <-- StartThreadDoStatus
     2015-02-09 15:59:02.870 RBA_SDK_Demo[5065:1439077] <2015-02-09 15:59:02.869> [DEBUG]:RBA_SDK: --> doStatus ...
     2015-02-09 15:59:02.871 RBA_SDK_Demo[5065:1438809] <2015-02-09 15:59:02.871> [DEBUG]:RBA_SDK: Connect = 0
     2015-02-09 15:59:43.784 RBA_SDK_Demo[5065:1439077] <2015-02-09 15:59:02.874> [DEBUG]:MessageManager: -->ProcessStatusRequest()
     2015-02-09 15:59:43.785 RBA_SDK_Demo[5065:1438809] <2015-02-09 15:59:43.785> [INFO ]:ViewController: Device connected
     2015-02-09 16:01:09.781 RBA_SDK_Demo[5065:1439077] <2015-02-09 15:59:43.788> [TRACE]:MessageManager: Send Status Message
     2015-02-09 16:01:09.782 RBA_SDK_Demo[5065:1439077] <2015-02-09 16:01:09.782> [DEBUG]:MessageManager: -->ExecuteSendSession wait replay = 1 for MsgId=11 with Message Timeout=10 sec.
     2015-02-09 16:01:09.783 RBA_SDK_Demo[5065:1439077] <2015-02-09 16:01:09.782> [DEBUG]:MessageManager: RBA SDK send Request

#16. using delegate to know if the connection is established.

#17. Everytime instance a Ingenico device, first make sure it support EMV
     Write config 0009_0001

#19. Bindo Process Flow:(Disable language selection, disable cash back, enable EMV, offline Advertising Mode 0010_0001 4, disable contact less)
     Note: change logic,
     1. when app open, connect to it. it unsuccessful, unregister the handler. If successful, handle configuration.
     1.5 when paynow button is pressed，set it online.(offline should be in advertising mode), then hardreset, start transaction, set the amount.
         when user cancel/transaction success/transaction failed, hardreset, then set offline.
         if hardrest MSG is received, always set the device offline.
     2. when app press paynowbutton, start transaction with amount 
     3. set to async mode to retreive the message.

     1. Initiate the device (open) ok
     2. Once ready(through -(void)RBA_Connected call back), check state: ok
        check if the EMV is enabled, if yes, do nothing; if no, enable it.
        check if the contactless is enabled, if yes, disable it; if no, do nothing.
        check if the cashback is enabled, if yes, disable it; it no, do nothing.
        Transaction Cancel 0013_0004
     3. When press some button. ok
        1. Notification: Online and Offline
        2. If yes:
           2.1 Set it online
           2.2 set transaction type
           2.3 set tranaction amount
        3. If cancel a transaction, set it offline
     ***************************
     4. Swipe card or Insert card (if failed, remind to re-swipe or re-insert) ok
        EMV:UNSOLOCITED MESSAGE
        1. RAW_PINPAD_RESPONSE=110  /**< If RBA_SDK doesn't recognize a message ID received from the terminal, then the callback will be called with a message ID of RAW_PINPAD_RESPONSE and a parameter ID of RAW_PINPAD_RESPONSE_DATA. */
        2. M33_02_EMV_TRANSACTION_PREPARATION_RESPONSE=102  /**< 33.02.X EMV transaction preparation response */ (AFTER CONFIRM APPLICATION TYPE)
        3. If unplug the credit card ->     M33_05_EMV_AUTHORIZATION_CONFIRMATION=105   /**< 33.05.X EMV Authorization confirmation */,
        4. M10_HARD_RESET
        5. M00_OFFLINE
    ????6. If the card is in the slot start to online, should tell user to get it out and set all to offline.(Push user to restart.)
     5. Select payment (Debit or Credit) ok
     6. Enter PIN (If Debit, input PIN; if Credit, no PIN) ok
     7. Verify purchase amount (if not, stop the transaction to offline) ok
        if NO key is pressed, the RBA always sends out the reset message (10.x), then we should cancel this transaction.(set it to offline).
     ?8. Authorization (return from ECR, if not authorized by ECR, just send offline)
        1. swipe
           1. credit card
              50: M50_AUTHORIZATION=50  /**< 50.x Authorization message is used to authorize a payment and display response. */
           2. debit card
              50: M50_AUTHORIZATION=50  /**< 50.x Authorization message is used to authorize a payment and display response. */
        2. EMV


     ?9. Approve
     ?10. Transaction End
     ?11. Advertising

#20. Question: page 26: Signing
     (Image should be Signing first by Ingenico?)
     Adv image replace it through tool directly

#21. Question: DFS -> config.dfs file or Write the file?
     (Already translated to .dat format, how to revise it before it is loaded into the device?)

#22. Question: Invalid PIN

B4270200026288408^MR.YUAN ZHANG MING        ^1610101001380000000000269000000

#23. P50_REQ_ACC_DATA_SOURCE                = D

     2015-02-14 15:59:11:291 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.291> [INFO ]:RBA_MSG: UNSOLOCITED MESSAGE               = 50

2015-02-14 15:59:11:291 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.291> [INFO ]:RBA_MSG: P50_REQ_ACQUIRING_BANK                 = 123456

2015-02-14 15:59:11:291 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.291> [INFO ]:RBA_MSG: P50_REQ_MERCHANT_ID                    = 789012345678

2015-02-14 15:59:11:292 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.292> [INFO ]:RBA_MSG: P50_REQ_STORE_ID                       = 9012

2015-02-14 15:59:11:292 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.292> [INFO ]:RBA_MSG: P50_REQ_PIN_PAD_ID                     = 3456

2015-02-14 15:59:11:293 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.292> [INFO ]:RBA_MSG: P50_REQ_STANDARD_INDUSTRY_CLASSIFICATION= 7890

2015-02-14 15:59:11:293 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.293> [INFO ]:RBA_MSG: P50_REQ_COUNTRY_OR_CURRENCY_TYPE       = 123

2015-02-14 15:59:11:293 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.293> [INFO ]:RBA_MSG: P50_REQ_ZIP_CODE                       = 45678

2015-02-14 15:59:11:293 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.293> [INFO ]:RBA_MSG: P50_REQ_TIME_ZONE_DIFF_FROM_GMT        = 900

2015-02-14 15:59:11:294 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.294> [INFO ]:RBA_MSG: P50_REQ_TRANSACTION_CODE               = 10

2015-02-14 15:59:11:294 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.294> [INFO ]:RBA_MSG: P50_REQ_PIN_PAD_SERIAL_NUM             = 20197434

2015-02-14 15:59:11:294 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.294> [INFO ]:RBA_MSG: P50_REQ_POS_TRANSACTION_NUM            = 0021

2015-02-14 15:59:11:295 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.295> [INFO ]:RBA_MSG: P50_REQ_ACC_DATA_SOURCE                = D

2015-02-14 15:59:11:295 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.295> [INFO ]:RBA_MSG: P50_REQ_MAG_SWIPE_INFO                 = 4270200026288408=16101010013826999999

2015-02-14 15:59:11:295 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.295> [INFO ]:RBA_MSG: P50_REQ_PIN_LENGTH                     = 12

2015-02-14 15:59:11:295 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.295> [INFO ]:RBA_MSG: P50_REQ_PIN_ENCRYPTED_BLOCK            = A5E3D9E50841E546

2015-02-14 15:59:11:295 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.295> [INFO ]:RBA_MSG: P50_REQ_PIN_KEY_SET_IDENTIFIER         = 543210

2015-02-14 15:59:11:295 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.295> [INFO ]:RBA_MSG: P50_REQ_PIN_DEVICE                     = 01F8A

2015-02-14 15:59:11:295 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.295> [INFO ]:RBA_MSG: P50_REQ_PIN_ENCRYPTION_COUNTER         = 00021

2015-02-14 15:59:11:295 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.295> [INFO ]:RBA_MSG: P50_REQ_TRANSACTION_AMOUNT             = 43400

2015-02-14 15:59:11:295 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.295> [INFO ]:RBA_MSG: P50_RES_PIN_PAD_SERIAL_NUM             = 

2015-02-14 15:59:11:295 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.295> [INFO ]:RBA_MSG: P50_RES_POS_TXN_NUM                    = 

2015-02-14 15:59:11:296 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.296> [INFO ]:RBA_MSG: P50_RES_RESPONSE_CODE                  = 

2015-02-14 15:59:11:296 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.296> [INFO ]:RBA_MSG: P50_RES_APPROVAL_CODE                  = 

2015-02-14 15:59:11:296 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.296> [INFO ]:RBA_MSG: P50_RES_TODAYS_DATE_YYMMDD             = 

2015-02-14 15:59:11:296 bindo-pos-dev[9681:ed27] Ingenico Trace Log: <2015-02-14 15:59:11.296> [INFO ]:RBA_MSG: P50_RES_PROMPT_INDEX_NUM               = 


# DUKPT 0
1. DUKPT 0 : F87654321001F8800001

#EMV
2015-02-14 19:33:05:959 bindo-pos-dev[10022:e923] Ingenico Trace Log: <2015-02-14 19:33:05.958> [INFO ]:RBA_MSG: UNSOLOCITED MESSAGE = 110

2015-02-14 19:33:05:959 bindo-pos-dev[10022:e923] Ingenico Trace Log: <2015-02-14 19:33:05.959> [INFO ]:RBA_MSG: RAW_PINPAD_RESPONSE

2015-02-14 19:33:16:038 bindo-pos-dev[10022:ec3f] Ingenico Trace Log: <2015-02-14 19:33:16.038> [INFO ]:RBA_MSG: UNSOLOCITED MESSAGE = 102

confirm the application selection

2015-02-14 19:33:16:039 bindo-pos-dev[10022:ec3f] Ingenico Trace Log: <2015-02-14 19:33:16.039> [INFO ]:RBA_MSG: M33_02_EMV_TRANSACTION_PREPARATION_RESPONSE


 !! Should enable auto application selection flag.


#24. PIN Block Format

# EMV data

2015-02-16 22:51:31:555 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.555> [INFO ]:RBA_MSG: UNSOLOCITED MESSAGE = 102

2015-02-16 22:51:31:556 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.556> [INFO ]:RBA_MSG: Tag=0x00004f                        = <a0000000 041010>

2015-02-16 22:51:31:556 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.556> [INFO ]:RBA_MSG: Tag=0x000050                        = <4d415354 45524341 5244>

2015-02-16 22:51:31:556 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.556> [INFO ]:RBA_MSG: Tag=0x000057                        = <54133300 89010665 d2512201 04933094 6f>
5413330089010665=2512201049330946

2015-02-16 22:51:31:556 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.556> [INFO ]:RBA_MSG: Tag=0x00005a                        = <54133300 89010665>

2015-02-16 22:51:31:556 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.556> [INFO ]:RBA_MSG: Tag=0x005f20                        = <496e7465 726f7065 722f2032 36203133 41>

2015-02-16 22:51:31:557 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.556> [INFO ]:RBA_MSG: Tag=0x005f24                        = <251231>

2015-02-16 22:51:31:557 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.557> [INFO ]:RBA_MSG: Tag=0x005f28                        = <0056>

2015-02-16 22:51:31:557 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.557> [INFO ]:RBA_MSG: Tag=0x005f30                        = <0201>

2015-02-16 22:51:31:557 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.557> [INFO ]:RBA_MSG: Tag=0x005f34                        = <00>

2015-02-16 22:51:31:557 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.557> [INFO ]:RBA_MSG: Tag=0x009f1a                        = <0840>

2015-02-16 22:51:31:557 bindo-pos-dev[11130:100f] Ingenico Trace Log: <2015-02-16 22:51:31.557> [INFO ]:RBA_MSG: Tag=0x009f1e                        = <32303139 37343334>


Printing description of dic:
{
    AID = A0000000041010;
    "Application Label" = MASTERCARD;
    "Application PAN Sequence Number" = 00;
    "Cardholder Name" = "Interoper/ 26 13A";
    "Expiry Date" = 251231;
    "IFD SN" = 20197434;
    "Issuer Country Code" = 0056;
    "Primary Account Number" = 5413330089010665;
    "Service Code" = 0201;
    "Terminal Country Code" = 0840;
    "Track2 Equivalent Data" = 5413330089010665D2512201049330946F;
}

#25. DUKPT
Regarding TDES DUKPT encryption, it must be enabled in the device.
To do so, there is a PGZ file that must be loaded (via a 62. File Write RBA message), and a subsequent reboot to active it.
 
The PGZ file is included in the Integration Kit ion the P2PE Configuration subfolder “TDES”.
ex. File path: IK-RBA-16.10\Telium RBA Parameters\P2PE Configuration\KP4\TDES\TDES1202.PGZ


#26. EMV
Debit : 0 0 2  0  14 10000 1 1 1 0      0 130 0 1 0 D 0 0 80e
        0 0 4  0   0     0 0 1 0 0      0 130 0 0 0 D 0 0 80e
Credit: 1 0 4  0   0     0 1 1 1 1      0 131 0 1 0 D 1 1 c0e
        1 0 4  0   0     0 0 1 0 0      0 131 0 0 0 D 0 0 c0e
EMV   : 0 0 4  0   0 10000 0 1 1 0      0 137 0 1 0 D 1 1 888
        1 0 4  0   0     0 0 1 0 0      0 137 0 0 0 D 0 0 888


#26. Transaction type
Refunding a transaction returns money back to a customer's credit card; it takes 3 to 5 business days for the transfer to complete.

Voiding a transaction cancels the original transaction as if it never happened and needs 1 to 3 business days to take affect.

Refunds should be used in the case where a charge has already been captured and settled.

Voids should be used when an authorization or charge has been made, but the transaction has not been settled yet.  Voids are more cost effective than refunds (but only works on unsettled transactions).

#27. PAN 
primary account number 

#28. rbamsg
0x0000000170499af0 iPP350 


0x000000017029e230 iCMP

#29. EMV Authorization Request Message: this the crucial message that should be received.







