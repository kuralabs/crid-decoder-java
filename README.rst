============
crid-decoder
============

Decoder for PDF417 data from Costa Rican id cards.


Compiling the library
=====================

First, install gradle and the wrapper at its version 3.3::

   gradle wrapper --gradle-version 3.3

Then, build jar archive::

   gradle jar

Library will be available in::

   build/libs/crid-decoder-<version>.jar


Running the test suite
======================

Build and run test suite::

   gradle test

Report will be available in::

   build/reports/tests/test/index.html


Building documentation
======================

Build reference documentation::

   gradle doc

Generated documentation will be available in::

   build/docs/javadoc/


License
=======

::

   Copyright (C) 2017 KuraLabs S.R.L

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing,
   software distributed under the License is distributed on an
   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
   KIND, either express or implied.  See the License for the
   specific language governing permissions and limitations
   under the License.
