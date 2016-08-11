.:: HUMIDOR-SERVER ::.
======================

Version: 0.0.1, 2016
Author: Filip Bielejec
License: LGPL

## PURPOSE

Backend for the humidor-app. Receives live data from Arduino, stores 30 round-robin entries in DB.

## Usage

   Dev:

   lein run [port]

    Production:

    $ java -jar humidor-server.jar [port]

## License

Copyright © 2016 fbielejec

  This is free software; you can redistribute it and/or modify
  it under the terms of the GNU Lesser General Public License as
  published by the Free Software Foundation; either version 2
  of the License, or (at your option) any later version.

   This software is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   [GNU Lesser General Public License](http://www.gnu.org/licenses/lgpl.html) for more details.

## TODO

Test for arduino POST route 

