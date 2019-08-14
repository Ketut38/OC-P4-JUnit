package com.dummy.myerp.business.impl.manager;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.TransactionStatus;

import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;
import com.dummy.myerp.testbusiness.BusinessTestCase;





public class ComptabiliteManagerImplTest extends BusinessTestCase {

    private ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();
    TransactionStatus vTS = getTransactionManager().beginTransactionMyERP();
    

    @Test
    public void checkEcritureComptableUnit() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                                                                                 null, null,
                                                                                 new BigDecimal(123)));
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitViolation() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG2() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                                                                                 null, new BigDecimal(123),
                                                                                 null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                                                                                 null, null,
                                                                                 new BigDecimal(1234)));
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG3() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), null));
        
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), new BigDecimal(123)));
        
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }

    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitFormatRG5() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle"); 
        
        
        manager.checkEcritureComptableUnit(vEcritureComptable);
    
    }
    
    @Test(expected = FunctionalException.class)
    public void checkEcritureComptableUnitRG5() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle"); 
        vEcritureComptable.setReference("AC-2019/00001");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1), "Achat", new BigDecimal(123), new BigDecimal(1234)));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2), "Banque", new BigDecimal(123), new BigDecimal(1235)));
        
        System.out.println(vEcritureComptable.getReference());
        
        manager.checkEcritureComptableUnit(vEcritureComptable);
    
    }
    
    @Test(expected = FunctionalException.class)
    public void checkRG5Test() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle"); 
        vEcritureComptable.setReference("AC-2018/00001");
       
        
        System.out.println(vEcritureComptable.getReference());
        
        manager.checkRG5(vEcritureComptable);
    
    }
    
    @Test(expected = FunctionalException.class)
    public void checkRG5RegexTest() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle"); 
        vEcritureComptable.setReference("AC-2019/00001");
       
        
        System.out.println(vEcritureComptable.getReference());
        
        manager.checkRG5Regex(vEcritureComptable);
    
    }
    
 // vérifier que l'année dans la référence correspond bien à la date de l'écriture, idem pour le code journal...
 	@Test
 	public void addReferenceTestWhenSequenceExist() throws Exception {
 		EcritureComptable vEcritureComptable;
		vEcritureComptable = new EcritureComptable();
		vEcritureComptable.setJournal(manager.getJournalComptableByCode("AC"));
		Date pDate = Date.from( Instant.ofEpochSecond(1466208000));
		//Date pDate = new Date(1466208000);
		vEcritureComptable.setDate(pDate);
		vEcritureComptable.setLibelle("Test");
		CompteComptable compte401 = manager.getCompteComptableByCode(401);
		CompteComptable compte512 = manager.getCompteComptableByCode(512);
		
		vEcritureComptable.getListLigneEcriture()
		.add(new LigneEcritureComptable(compte401, null, new BigDecimal(123), null));
		vEcritureComptable.getListLigneEcriture()
		.add(new LigneEcritureComptable(compte512, null, null, new BigDecimal(123)));

		manager.addReference(vEcritureComptable);
		
		String reference = vEcritureComptable.getReference();
		char[] yearOfRef = {reference.charAt(3), reference.charAt(4), reference.charAt(5), reference.charAt(6)};
		String strYear = String.valueOf(yearOfRef);
		
		Calendar calendar = new GregorianCalendar();
    	calendar.setTime(vEcritureComptable.getDate());
    	//recuperation de l'année de l'ecriture
    	int yearFromTest = calendar.get(Calendar.YEAR);
    	int yearFromReference = Integer.parseInt(strYear);
    	
    	Assert.assertTrue(yearFromTest == yearFromReference);
    	getTransactionManager().rollbackMyERP(vTS);

 		
 	}
}
