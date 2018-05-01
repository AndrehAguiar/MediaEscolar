<?php

define('HostName', 'localhost');
define('HostUser', 'appUser');
define('HostPass', 'pass_db');
define('DataBaseName', 'db_media_escolar');

$conn = mysqli_connect(HostName,HostUser,HostPass,DataBaseName) or die("Falha ao conectar ao BD");
//include("testarConexao.php");

?>