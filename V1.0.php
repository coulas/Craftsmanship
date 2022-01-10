<html>
<head>
	
</head>
<body>
<?php

//Definicion de las clases a utilizar bingo que gestionará el juego
class bingo
{

	public $cantidad; 
	public $numerosSeleccionados = array();
	public $jugadores = array();
	public $ganadores = null;

	function _construct()
	{
		$this->cantidad = 0;
		$this->numerosSeleccionados = array();
		$this->jugadores = arrray();
		$this->ganadores = array();
	}

	//Genera números aleatorios del juego del 1 al 75
	function generarNumeros($cantidadJugadores)
	{
	
	//Inicializamos el arreglo de ganadores vacío al inicio
	$this->ganadores = array();
	

	//Generamos una cartilla diferente USA por cada jugador que participará en el juego
	$this->generarCartillas($cantidadJugadores);
	

	//Se itera en el juego mientras todavía no han salido los 75 números y no hay ganadores
	while($this->cantidad < 75 && $this->ganadores ==null){
	
	//Genera el número aleatorio
	$numero_aleatorio = rand(1,75);
	
	//verifica si se llamó al número aleatorio antes
	if($this->llamo($numero_aleatorio)==0)
	{
		
		//Se agrega el número seleccionado al arreglo de números seleccionados
		array_push($this->numerosSeleccionados, $numero_aleatorio);
		
		//Aumenta la cantidad de números seleccionados diferentes
		$this->cantidad++;


		echo "Se llamó al número: ".$numero_aleatorio."\n"; 

		//Se marca la cartilla de bingo de cada juagador dependiendo si tiene al número seleccionado
		$this->marcarNumeros($cantidadJugadores,$numero_aleatorio);
	
		//Se llama a bingo si algún jugador completó sus 24 números + 1 en blanco
		//y se agrega al arreglo de ganadores, en caso de empate se guardan los demás ganadores
		// y a penas se encuentre un ganador se sale del juego
		$this->ganadorJuego($cantidadJugadores);
	}
	
	} 
	

	//Se hace una segunda verificación de la cartilla de los ganadores para saber si tienen marcados los números escogidos
	$this->verificarGanadorPorJugador();
	}

	//Comprueba si el número escogido ya ha salido o sea a llamado antes en el juego
	function llamo($numero)
	{
		if($this->numerosSeleccionados == null)
		{//Si es el primer número se agrega al arreglo
			return 0;
		}
		else{
			//Si no es el primer número se busca si ha sido llamado
		foreach ($this->numerosSeleccionados as $key ) {
			if($key == $numero)
			{
				return 1;
			}
		}
		 }
		return 0;
	}


	function generarCartillas($cantidadJugadores)
	{
	//Se asigna la cartilla nueva a cada juagador y se almacena al jugador en el arreglo "jugadores"
	for ($i=0; $i <$cantidadJugadores ; $i++) { 
		$jugador = new bingoCardGenerator();
		$jugador->generarNumeros();
		array_push($this->jugadores, $jugador);

	}
}

	function marcarNumeros($cantidadJugadores,$numero)
	{
	for ($i=0; $i <$cantidadJugadores ; $i++) { 
	//Por cada jugador se marca los números (salió) que tiene en su cartilla
	$this->jugadores[$i]->marcar($numero);
}

}


function ganadorJuego($cantidadJugadores)
{
//Se itera por cada jugador para saber si completó su cartilla con 24 posiciones
for ($i=0; $i < $cantidadJugadores; $i++) { 
	if($this->jugadores[$i]->numerosMarcados == 24)
	{ //Comprobamos con 24 ya que la casilla en blanco 0 se considera como marcada para todos los jugadores
		//y almacenamos todos los ganadores en el arreglo de juagadores "Ganadores" para saber si hubo empate
		// o un único ganador
		array_push($this->ganadores, $this->jugadores[$i]);

	}
}

}


//Verifica si los jugadores ganadores realmente ganaron, aunque en la lógica principal ya se encuentra la verificación
function verificarGanadorPorJugador()
{
	foreach ($this->ganadores as $key) {
		if($this->verificarGanador($key)== 1)
			{
				echo "Jugador ha ganado";
			}
		else
		{
			echo "Jugador no ha ganado";
		}
	}

}

//Verifica si un jugador ganó
function verificarGanador($posibleGanador)
{$cantidadMarcasComprobar = 0;


for ($j=0; $j <$this->cantidad ; $j++) { 
//Dependiendo del valor del número se decide en qué columna de la matriz cartilla del jugador buscar si tiene el número
	if($this->numerosSeleccionados[$j]<=15)
		{
			for ($k=0; $k <5 ; $k++) { 
				//Se itera en los 5 posibles valores de cada columna de la cartilla y se busca el número que le bingo generó
				if($posibleGanador->cartilla[0][$k]==$this->numerosSeleccionados[$j]){
					$cantidadMarcasComprobar++; //Se encontró el número en la cartilla, se aumenta el contador de verificación
					
				}
			}

		}
		else if($this->numerosSeleccionados[$j]>15 && $this->numerosSeleccionados[$j]<=30)
		{
			for ($k=0; $k <5 ; $k++) { 
				if($posibleGanador->cartilla[1][$k]==$this->numerosSeleccionados[$j]){
					$cantidadMarcasComprobar++;
					
				}
			}
		}
		else if($this->numerosSeleccionados[$j]>31 && $this->numerosSeleccionados[$j]<=45)
		{
			for ($k=0; $k <5 ; $k++) { 
				if($posibleGanador->cartilla[2][$k]==$this->numerosSeleccionados[$j]){
					$cantidadMarcasComprobar++;
					
				}
			}
		}
		else if($this->numerosSeleccionados[$j]>46 && $this->numerosSeleccionados[$j]<=60)
		{
			for ($k=0; $k <5 ; $k++) { 
				if($posibleGanador->cartilla[3][$k]==$this->numerosSeleccionados[$j]){
					$cantidadMarcasComprobar++;
					
				}
			}
		}
		else if($this->numerosSeleccionados[$j]>60 & $this->numerosSeleccionados[$j]<=75)
		{
			for ($k=0; $k <5 ; $k++) { 
				if($posibleGanador->cartilla[4][$k]==$this->numerosSeleccionados[$j]){
					$cantidadMarcasComprobar++;
					
				}
			}
		}
if($cantidadMarcasComprobar==24)
{
	return 1; //Se comprueba que el juegador tiene una cartilla ganadora con 24 posiciones completas
}
}
return 0; //El jugador no ha ganado ya que tiene menos de 24 posiciones completas
}




}



//La clase que controla las cartillas de los jugadores
class bingoCardGenerator
{
	//Se inicializa la cartilla general de cada jugador
	public $cartilla = array();
	//Se inicializan los arreglos que representarán cada columna de la cartilla
	public $columnaB = array(); 
	public $columnaI = array();
	public $columnaN = array();
	public $columnaG = array();
	public $columnaO = array();

	//Contadores de la cantidad de elementos completados en cada columna
	public $cantidad; 
	public $cantidadB, $cantidadI, $cantidadN, $cantidadG, $cantidadO;
	
	public $numerosSeleccionados = array();
	
	//Almacena la cantidad de número marcados dependiendo de si salió en el bingo o no
	public $numerosMarcados;

	//Constructor de la clase, inicializa los valores de manera adecuada
	function _construct()
	{
		$cantidad = 0;

		$cantidadB = 0;
	

		$cantidadI = 0;
	

		$cantidadN = 0;
	

		$cantidadG = 0;

		$cantidadO = 0;

		$numerosMarcados = 0;
	
	
		$this->numerosSeleccionados = array();
		$this->columnaO = array();
		$this->columnaG = array();
		$this->columnaN = array();
		$this->columnaI = array();
		$this->columnaB = array();
	}

	//Recibe un número del bingo y verifica según el rango en qué arreglo que representa la columa iterar
	//así se evita recorrer todos los arreglos
	function marcar($numero)
	{
		if($numero<=15) //Columna B
		{
			for ($i=0; $i <5 ; $i++) { 
				if($this->cartilla[0][$i]==$numero){
					$this->numerosMarcados++; //Se encontró el n+umero en la cartilla, se devuele 1
					return 1;
				}
			}

		}
		else if($numero>15 && $numero<=30) //Columna I
		{
			for ($i=0; $i <5 ; $i++) { 
				if($this->cartilla[1][$i]==$numero){
					$this->numerosMarcados++;
					return 1; //Se encontró el número en la cartilla, se devuelve 1
				}
			}
		}
		else if($numero>31 && $numero<=45) //Columna N
		{
			for ($i=0; $i <5 ; $i++) { 
				if($this->cartilla[2][$i]==$numero){
					$this->numerosMarcados++;
					return 1;
				}
			}
		}
		else if($numero>46 && $numero<=60) //Columna G
		{
			for ($i=0; $i <5 ; $i++) { 
				if($this->cartilla[3][$i]==$numero){
					$this->numerosMarcados++;
					return 1;
				}
			}
		}
		else if($numero>60 & $numero<=75) //Colummna O
		{
			for ($i=0; $i <5 ; $i++) { 
				if($this->cartilla[4][$i]==$numero){
					$this->numerosMarcados++;
					return 1;
				}
			}
		}
		return 0; //Numero no marcado o no encontrado en la cartilla, se devueve 0
	}

	//Genera números aleatorios del juego del 1 al 75
	function generarNumeros()
	{

	
	while($this->cantidadI < 5 || $this->cantidadB<5 || $this->cantidadN<5 
		|| $this->cantidadG<5 || $this->cantidadO <5){
	//Genera el número aleatorio


		//Dependiendo de la columna a completar se va agregando elementos a cada arreglo
		// individual i ( i=1=columna B, i=2= columna I , ..., i = 5 = columna O)
		
	//Números para la columna B
	if($this->cantidadB<5)
		{


		$numero_aleatorio = rand(1,15);
	
	if($this->llamo($numero_aleatorio)==0)
	{
		array_push($this->numerosSeleccionados, $numero_aleatorio);
		array_push($this->columnaB, $numero_aleatorio);
		
		$this->cantidadB++;

	

	}
		}
	
	//Números para la columna I
	else if ($this->cantidadI<5)
		{

		$numero_aleatorio = rand(16,30);
	
		if($this->llamo($numero_aleatorio)==0)
	{
		array_push($this->numerosSeleccionados, $numero_aleatorio);
		array_push($this->columnaI, $numero_aleatorio);
		
		$this->cantidadI++;
		
	}
		}
	//Números para la columna N y así sucesivamente
		else if ($this->cantidadN<5)
		{

		$numero_aleatorio = rand(31,45);
		if($this->llamo($numero_aleatorio)==0)
	{

		if($this->cantidadN==2)
		{ //Elemento del centro
		array_push($this->numerosSeleccionados, $numero_aleatorio);
		array_push($this->columnaN, 0);
		//0 representa un espacio en blanco

		}else{ 
		array_push($this->numerosSeleccionados, $numero_aleatorio);
		array_push($this->columnaN, $numero_aleatorio);
		}
		
		$this->cantidadN++;
		 
	}
		}
		else if($this->cantidadG<5)
		{

		$numero_aleatorio = rand(46,60);
		if($this->llamo($numero_aleatorio)==0)
	{
		array_push($this->numerosSeleccionados, $numero_aleatorio);
		array_push($this->columnaG, $numero_aleatorio);
		
		$this->cantidadG++;
		
	}
		}
		elseif ($this->cantidadO <5) {
			
		$numero_aleatorio = rand(61,75);
		if($this->llamo($numero_aleatorio)==0)
	{
		array_push($this->numerosSeleccionados, $numero_aleatorio);
		array_push($this->columnaO, $numero_aleatorio);


		$this->cantidadO++;
		 }
		}


	} 
	
	//Se agrega la matriz cartilla que cuenta con una arreglo por cada columna
	array_push($this->cartilla, $this->columnaB); //0
	array_push($this->cartilla, $this->columnaI); //1
	array_push($this->cartilla, $this->columnaN); //2
	array_push($this->cartilla, $this->columnaG); //3
	array_push($this->cartilla, $this->columnaO); //4

	print_r($this->cartilla);


	}

	function llamo($numero)
	{//Se verifica si se llamó al número generado anteriormente, almacenado en el arreglo
		//numerosSeleccionados
		if($this->numerosSeleccionados == null)
		{
			return 0;
		}
		else{
		foreach ($this->numerosSeleccionados as $key ) {
			if($key == $numero)
			{
				return 1;
			}
		}
		 }
		return 0;
	}
}

// Programa a implementar

//Inicia el juego
$juego = new bingo;
//Cantidad de números a salir, al inicio es 0 
$juego->cantidad = 0;

//Ingresar la cantidad de jugadores
$cantidadJugadores = 4;
echo "Iniciar el juego: ". $juego->generarNumeros(4);


?>

</body>
</html>