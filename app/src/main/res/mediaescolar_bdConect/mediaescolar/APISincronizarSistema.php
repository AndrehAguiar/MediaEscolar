<?php

header('Content-type: application/json');

ini_set('default_charset', 'utf-8');

$response = array();

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    require_once('db_config.php');

    mysqli_set_charset($conn, "utf8");

    $statement = mysqli_prepare($conn, 
    "SELECT * from media_escolar order by id");

    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement,
						    $id,
						    $materia,
						    $bimestre,
						    $situacao,
						    $notaProva,
						    $notaMateria,
						    $mediaFinal); 
 

    if (mysqli_stmt_num_rows($statement) > 0) {

        while (mysqli_stmt_fetch($statement)) {

            array_push($response, array(
                "id" => $id,
                "materia" => $materia,
                "bimestre" => $bimestre,
                "situacao" => $situacao,
                "notaProva" => $notaProva,
                "notaMateria" => $notaMateria,
                "mediaFinal" => $mediaFinal
                )
            );
        }
        
          
          
    } else {
    
           $response["sucesso"] = false;
    }

    echo json_encode($response);
    
} else {

    
    $response["sucesso"] = false;
    
    echo json_encode($response);
}
?>
	