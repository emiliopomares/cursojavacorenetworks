const fs = require('fs')

fileContents = fs.readFileSync('./Readme.json')
object = JSON.parse(fileContents)

console.log("Age of pet owner: " + object.Age)
