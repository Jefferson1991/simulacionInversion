# Simulacion de Inversión 
UNIVERSIDAD TECNOLÓGICA ISRAEL
LABORATORIO SEMANA 2
2025A – MOMENTO 2
DOCENTE: Mg. Carlos Salazar

ASIGNATURA: DESARROLLO DE SOFTWARE II
CARRERA: SISTEMAS DE INFORMACIÓN

Problema:
Una institución financiera desea incorporar en su portal web una calculadora de inversiones para incentivar la recaudación en la población en general. En este sentido, la calculadora debe permitir:
Dar a conocer el valor futuro de una póliza de inversión luego de cierto tiempo, considerando que los intereses se capitalizan de manera compuesta. Escribe un programa que calcule el monto acumulado (valor futuro) de una inversión inicial, aplicando la fórmula del interés compuesto.
A = P├ (1 + r/n┤)^nt
Donde:
	A: Monto final (valor futuro de la inversión)
	P: Capital inicial (monto invertido)
	r: Tasa de interés anual (en decimal, por ejemplo, 5% = 0.05)
	n: Número de veces que se capitaliza el interés por año (por ejemplo, 12 para mensual, 4 para trimestral y 2 para semestral)
	t: Tiempo en años
Requerimientos Funcionales
	Solicitar al usuario los siguientes datos:
	Nombres, cédula, email, celular
	Capital inicial P (Solo se acepta valores superiores a 100 USD)
	Número de periodos de capitalización por año n
	Tiempo en años t
	La tasa de interés anual es: 
	5% si la capitalización del interés es semestral
	7% trimestral
	 11% mensual.
	Calcular el valor futuro A utilizando la fórmula de interés compuesto.
	Mostrar al usuario el monto acumulado al final del periodo, así como el interés ganado
	Validación de formulario
	Por cada simulación, el aplicativo debe categorizar al cliente siguiendo las siguientes reglas:
	Categoría 3: Capital inicial entre 100 y 500 USD Y n = 12 
	Categoría 2: Capital inicial entre 501 y 1000 USD Y n = 12
	Categoría 1: Capital inicial superior a 1000 USD Y n = 12

	Almacenar en Base de datos cada simulación con todos los valores generados para un futuro análisis
	Se debe visualizar todas las simulaciones elaboradas en una tabla.

