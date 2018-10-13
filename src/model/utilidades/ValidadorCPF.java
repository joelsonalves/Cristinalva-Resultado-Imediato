package model.utilidades;

/*
 * Fonte: https://www.vivaolinux.com.br/script/Codigo-para-validar-CPF-e-CNPJ-otimizado
 */

public class ValidadorCPF {
	
	private static final int[] peso = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	
	private static int calcularDigito(String str) {
		
		int soma = 0;
		
	    for (int indice = str.length()-1, digito; indice >= 0; indice-- ) {
	    	digito = Integer.parseInt(str.substring(indice,indice+1));
	        soma += digito * peso[peso.length - str.length() + indice];
	    }
	    
	    soma = 11 - soma % 11;
	    
	    return soma > 9 ? 0 : soma;
	    
	}
	
	public static boolean isValido(String cpf) {
	   
		char[] aCPF = cpf.toCharArray();
		
		if ((cpf == null) || (cpf.length()!= 11)) return false;
		
		for (char c : aCPF) {
			
			if (c < '0' || c > '9') return false;
			
		}
		
		if (aCPF[0] == aCPF[1] && aCPF[1] == aCPF[2] && aCPF[2] == aCPF[3] 
				&& aCPF[3] == aCPF[4] && aCPF[4] == aCPF[5] && aCPF[5] == aCPF[6]
						&& aCPF[6] == aCPF[7] && aCPF[7] == aCPF[8])
			return false;

	    Integer digito1 = calcularDigito(cpf.substring(0,9));
	    Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1);
	    
	    return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
	    
	}

}
