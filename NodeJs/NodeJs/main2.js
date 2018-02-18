/* Hello, World! program in node.js */
console.log("Hello, World!")
    
 var pg = require("pg");
//or native libpq bindings
//var pg = require('pg').native
var http = require('http');
var bodyparser = require('body-parser')
var express = require('express');
var conString = process.env.ELEPHANTSQL_URL || "postgres://postgres:sa@localhost:5432/postgres";
var client = new pg.Client(conString);
var app = express();
app.use(bodyparser.json());

client.connect(function(err) {
if(err) {
   return console.error('could not connect to postgres', err);
  }
   client.query('select * from employee', function(err, result) {
    if(err) {
      return console.error('error running query', err);
    }
	
    console.log(result);
    //output: Tue Jan 15 2013 19:12:47 GMT-600 (CST)
    client.end();
  });
  
});
 
var conString1 = process.env.ELEPHANTSQL_URL || "postgres://postgres:sa@localhost:5432/postgres";
var client2 = new pg.Client(conString);

http.createServer(function (req, res) {
	res.writeHead(200, {'Content-Type': 'application/json'});
	client2.connect(function(err) {
	if(err) {
	   return console.error('could not connect to postgres', err);
	  }
   client2.query('select * from employee', function(err, result) {
    if(err) {
      return console.error('error running query', err);
    }
	res.end(JSON.stringify(result.rows));
  //res.write('Hello World!'); //write a response to the client
  res.end(); //end the response
   });
	});
   
}).listen(9080); //the server object listens on port 8080


//var conString = process.env.ELEPHANTSQL_URL || "postgres://postgres:sa@localhost:5432/postgres";

//var client = new pg.Client(conString);
//client.connect(function(err) {
//  if(err) {
//    return console.error('could not connect to postgres', err);
//  }
//  client.query('select * from employee', function(err, result) {
//    if(err) {
//      return console.error('error running query', err);
//    }
	
//    console.log(result);
    //output: Tue Jan 15 2013 19:12:47 GMT-600 (CST)
//    client.end();
//  });
  
//});
 
