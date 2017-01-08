<?php

/* JSON OUTPUT CODE */

//Set post data fields
$arr_post_data = array(
	'api_key' => API_KEY,
	'api_hash' => API_HASH,
	'format' => 'json',
	'query_name' => QUERY_NAME,
	'csv_with_headers' => '1'
);
$str_post_data = http_build_query($arr_post_data);

//Set http headers
$arr_http_headers = array(
	'Content-Type: application/x-www-form-urlencoded',
	'Content-Length: '.strlen($str_post_data),
	'Authorization: Basic '.base64_encode('API_USER:API_PASS')
);

//Open curl session
$res_curl = curl_init(API_URL);

//Set headers and data for http post request
curl_setopt($res_curl, CURLOPT_POST, true);
curl_setopt($res_curl, CURLOPT_HTTPHEADER, $arr_http_headers);
curl_setopt($res_curl, CURLOPT_POSTFIELDS, $str_post_data);
curl_setopt($res_curl, CURLOPT_RETURNTRANSFER, true);
curl_setopt($res_curl, CURLOPT_HEADER, false);

//Send request and get response
$str_response = curl_exec($res_curl);

//Close curl session
curl_close($res_curl);


//first line of the $str_response is the header telling operation status ie. success or failure
/*
*	format of the response header on success eg.
*	"Result:","success","Rows Returned:","3145","Error Message","none"
*
*	format of the response header on success eg.
*	"Result:","fail","Rows Returned:","0","Error Message","SOME ERROR MESSAGE"
*/

//Get the response status i.e. success or failed
	$obj_response = json_decode_function($str_response);	
	//$obj_response = json_decode_function($str_response);

	//echo $obj_response;exit;
	$str_response_status = $obj_response['envelope']['header'][0][1];

	//Check if response status is success or not and take appropriate action accordingly
	if(strtoupper($str_response_status)=='SUCCESS') {
		//things to do with the file you have got
		echo $str_response;
		//print('SUCCESS');
	}else {
		//things to do when error - you didn't get file
		print('FAIL');
	}


}

function json_decode_function($json)
{
    $comment = false;
    $out = '$x=';
 
    for ($i=0; $i<strlen($json); $i++)
    {
        if (!$comment)
        {
            if (($json[$i] == '{') || ($json[$i] == '['))       $out .= ' array(';
            else if (($json[$i] == '}') || ($json[$i] == ']'))   $out .= ')';
            else if ($json[$i] == ':')    $out .= '=>';
            else                         $out .= $json[$i];         
        }
        else $out .= $json[$i];
        if ($json[$i] == '"' && $json[($i-1)]!="\\")    $comment = !$comment;
    }
    eval($out . ';');
    return $x;
}

?>
