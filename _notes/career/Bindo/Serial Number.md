serial Number
==============

Client:

1. if listing SN is enabled and listing track number. The minus number should >= serial number fulfilled

2. if listing SN has been deleted, in fulfill SN it should be dark and should not be able to edit.

   delete listing SN will not delete PI SN, delete PI SN will delete corresponding listing SN.

3. save the serial number in client database

Server:

1. fulfill api:

   create: create PI SN and listing SN
   return: return PI SN along with listing SN
   update: update listing SN associated with listing SN
   delete: delte listing SN then delete PI SN

2. Cancel: 

   if marked as canceled, should delete all the listing SN and all the PI SN.

3. Edit -> save

   delete a PI should delete all the listing SN and all the PI SN associated.