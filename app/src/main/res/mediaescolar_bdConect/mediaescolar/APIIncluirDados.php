<?php
header('Content-Type: text/html; charset=utf-8');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('db_config.php');

    mysqli_set_charset($conn, "utf8");

    $materia = $_POST["materia"];
    $bimestre = $_POST["bimestre"];
    $situacao = $_POST["situacao"];
    $mediaFinal = $_POST["mediaFinal"];   
    $notaProva = $_POST["notaProva"]; 
    $notaMateria = $_POST["notaMateria"];

    $sql = "INSERT INTO media_escolar(materia, bimestre, situacao, notaProva, notaMateria, mediaFinal) VALUES ('$materia', '$bimestre', '$situacao', '$notaProva', '$notaMateria', '$mediaFinal')";
            
    if (mysqli_query($conn, $sql))
     {
			echo "Sucesso";			
      } else {
      
            echo "Erro ".$sql;
      }

    mysqli_close($conn); 
    
} else {
   
  echo "Acesso Negado";
}

?>