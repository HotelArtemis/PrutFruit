<?php

$username = "$$$$$$$$$$$$$";
$servername = "##########";
$dbname = "###########";
$password = "###########";

$conn = new mysqli($servername,$username,$password,$dbname);

if($conn->connect_error)
{
	die("koneksi gagal". $conn->connect_error);
}
$sql = "SELECT * FROM $$##########";

$result = $conn->query($sql);
$data = array();

if ($result->num_rows>0)
{
	while($row = $result->fetch_assoc())
	{
		$data[]=$row;
	}
}
else
{
	echo "0 result";
}
	echo json_encode($data);
	$conn->close();
?>
