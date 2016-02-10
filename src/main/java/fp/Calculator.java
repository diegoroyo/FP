package fp;

import java.util.List;
import java.util.ArrayList;

public class Calculator {
	/*
	 * este metodo calcula el seno de un angulo
	 */
	static Double sin(double n) {
		return (double) Math.round(Math.sin(Math.toRadians(n)) * 10) / 10;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	static int[] stepThisNumber(int number, int step) {
		if (number > 0 && step > 0)
		{
			int arrayLength = (number - 1) / step;
			int[] numberArray = new int[arrayLength];
			for (int i = 0; i < arrayLength; i++)
			{
				numberArray[i] = number - step * (i + 1);
			}
			return numberArray;
		}
		return new int[]{};
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	static int[] divisors(int n) {
		if (n > 0)
		{
			List<Integer> numberList = new ArrayList<Integer>();
			for (int i = n; i > 0; i--)
			{
				if (n % i == 0)
				{
					numberList.add(i);
				}
			}
			
			int[] array = new int[numberList.size()];
			int i = 0;
			for (Integer listValue : numberList)
			{
				array[i++] = listValue;
			}
			
			return array;
		}
		
		return null;
	}

	/*
	 * Toma como parámetros dos listas. La primera con los 6 números de una
	 * apuesta de la primitiva, y la segunda con los 6 números ganadores. La
	 * función debe devolver el número de aciertos.
	 */
	static Integer checkMyBet(List<Integer> apuesta, List<Integer> aciertos) {
		int correctos = 0;
		if (apuesta != null && aciertos != null)
		{
			for (int i = 0; i < 6; i++)
			{
				if (apuesta.get(i) == aciertos.get(i))
				{
					correctos++;
				}
			}
		}
		return correctos;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	static String speakToMe(int n) {
		String respuesta = "";
		String[] decenas = {"", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
		String[] unidades = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
		
		if (n > 10 && n < 16)
		{
			switch(n)
			{
			case 11:
				respuesta = "once";
				break;
			case 12:
				respuesta = "doce";
				break;
			case 13:
				respuesta = "trece";
				break;
			case 14:
				respuesta = "catorce";
				break;
			case 15:
				respuesta = "quince";
				break;
			}
		}
		else
		{
			if (n > 15 && n < 20)
			{
				respuesta = "dieci";
			}
			else if (n > 20 && n < 30)
			{
				respuesta = "veinti";
			}
			else
			{
				respuesta = decenas[(int)Math.floor(n / 10)];
				if (n % 10 != 0 && n > 10)
				{
					respuesta += " y ";
				}
			}
			if (n % 10 != 0 || n == 0)
			{
				respuesta += unidades[n % 10];
			}
		}
		
		return Character.toUpperCase(respuesta.charAt(0)) + respuesta.substring(1);
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	static boolean isLeapYear(String fecha) {
		if (fecha.length() == 10)
		{
			int year = Integer.parseInt(fecha.substring(6, 10));
			return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
		}
		return false;
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	static boolean isValidDate(String date) {
		int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (date.length() == 10)
		{
			int day = Integer.parseInt(date.substring(0, 2));
			int month = Integer.parseInt(date.substring(3, 5));
			int year = Integer.parseInt(date.substring(6, 10));
			
					// Comprobar que ni DMY > 0 y < de lo que tendrian que serlo
			return (year > 0 && month > 0 && month <= 12 && day > 0 && day <= monthDays[month - 1])
					// Excepcion para el 29 de febrero de a�os bisiestos
					|| (year > 0 && isLeapYear(date) && month == 2 && day == 29);
		}
		return false;
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la
	 * cadena resulta ser un palíndromo
	 */
	public static Boolean checkIsPalindrome(String cadena) {
		if (cadena != null)
		{
			char[] caracteresEspeciales = {'á', 'à', 'ä', 'é', 'è', 'ë', 'í', 'ì', 'ï', 'ó', 'ò', 'ö', 'ú', 'ù', 'ü'};
			char[] caracteresEspecialesParaCambiar = {'a', 'e', 'i', 'o', 'u'};
			char[] caracteresValidos = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
			
			cadena = cadena.toLowerCase();
			String nuevaCadena = "";
			boolean done = false;
			
			// Crear un nuevo String con solo caracteres validos
			for (int i = 0; i < cadena.length(); i++)
			{
				done = false;
			
			    // Letras especiales: á, è, ï -> a, e, i
				for (int j = 0; j < caracteresEspeciales.length; j++)
				{
					if (cadena.charAt(i) == caracteresEspeciales[j])
					{
						nuevaCadena += caracteresEspecialesParaCambiar[j / 3];
						done = true;
						break;
					}
				}
				
				// Letras normales: a, b, c
				if (!done)
				{
					for (int k = 0; k < caracteresValidos.length; k++)
					{
						if (cadena.charAt(i) == caracteresValidos[k])
						{
							nuevaCadena += caracteresValidos[k];
							break;
						}
					}
				}
			}
			
			// Comprobar si es palindromo
			boolean esPalindromo = true;
			int length = nuevaCadena.length();
			for (int i = 0; i < (length / 2); i++)
			{
				if (nuevaCadena.charAt(i) != nuevaCadena.charAt(length - i - 1))
				{
					esPalindromo = false;
					break;
				}
			}
			return esPalindromo;
			
		}
		return false;
	}


	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		List<Integer> secuencia = new ArrayList<Integer>();
		int a = 1;
		int b = 0;
		while (n > 0)
		{
			secuencia.add(a);
			a += b;
			b = a - b;
			n--;
		}
		return secuencia;
	}


	
}
