package com.temenos.dev;

import com.temenos.api.TField;
import com.temenos.api.TStructure;
import com.temenos.api.TValidationResponse;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.fundstransfer.FundsTransferRecord;

/**
 * TODO: Document me!
 *
 * @author training9
 *
 */
public class CheckFt extends RecordLifecycle{

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        // TODO Auto-generated method stub
        
        
        FundsTransferRecord ftRecord = new FundsTransferRecord(currentRecord);
        
        TField debitAmount = ftRecord.getDebitAmount();
        
        Double limit = 100.00 ;
        
        Double amount = Double.parseDouble(debitAmount.getValue());
        if(amount > limit)
        {
           debitAmount.setError("Amount should be enter below 100"); 
        }
        
        
        return ftRecord.getValidationResponse();
    }
    

    
}
