/* Hello, World! program in node.js */
console.log("Hello, World!")
    
 var pg = require("pg");
//or native libpq bindings
//var pg = require('pg').native

var conString = process.env.ELEPHANTSQL_URL || "postgres://postgres:sa@localhost:5432/postgres";

var client = new pg.Client(conString);
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
 
