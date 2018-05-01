<?php

header('Content-Type: text/html; charset=utf-8');

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('db_config.php');

    mysqli_set_charset($conn, "utf8");

    $idpk = $_POST["idpk"];

    $sql = "DELETE FROM media_escolar                         
         WHERE media_escolar.id = '$idpk'";

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