package com.mmendoza;

import java.util.ArrayList;

public class Profesor extends Usuario{

	@Override
	public Integer getLimite() {
		return 3;
	}

	@Override
	protected void  solicitarLibro(ArrayList<String> titulos) {
		if(titulos.size() >= getLimite())
			 throw new  RuntimeException("Superaste el limite"); //TODO
		
		super.solicitarLibro(titulos);
	}

}
