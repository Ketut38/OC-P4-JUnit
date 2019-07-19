package com.dummy.myerp.model.bean.comptabilite;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CompteComptableTest {

	@Test
	public void testGetByNumero() {
		
		List<CompteComptable> listCompte = new ArrayList<CompteComptable>();
		
		listCompte.add(new CompteComptable(001,"Abbes"));
		listCompte.add(new CompteComptable(002,"Dell"));
		listCompte.add(new CompteComptable(003,"Lenovo"));
		listCompte.add(new CompteComptable(004,"Capgemini"));
		
		Assert.assertEquals(CompteComptable.getByNumero(listCompte, 003), listCompte.get(2));
		
	}

}
