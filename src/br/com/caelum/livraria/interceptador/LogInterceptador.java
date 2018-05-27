package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception{
		long millis = System.currentTimeMillis();
		
		// chamada do metodo do DAO
		Object obj = context.proceed();
		
		// recupera nome do metodo interceptado
		String nomeMetodo = context.getMethod().getName();
		
		// recupera nome da classe interceptor
		String nomeClasse = context.getTarget().getClass().getSimpleName();
		
		System.out.println("Classe: " + nomeClasse + ", " + "Método: " + nomeMetodo);
		System.out.println("tempo gasto: " + (System.currentTimeMillis() - millis));
		return obj;
	}
}
