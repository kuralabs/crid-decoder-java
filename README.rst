============
crid-decoder
============

.. image:: https://build.kuralabs.io/buildStatus/icon?job=GitHub/crid-decoder/master
   :target: https://build.kuralabs.io/job/GitHub/job/crid-decoder/job/master/
   :alt: Build status

Decoder for PDF417 data from Costa Rican id cards.

    https://docs.kuralabs.io/crid-decoder/

Usage
=====

Import decoder and result object:

.. code-block:: java

   import io.kuralabs.crid.decoder.IdDecoder;
   import io.kuralabs.crid.decoder.Person;

.. code-block:: java

   // byte[] decodingKey = new byte[] {(byte)0x00, ...};
   IdDecoder decoder = new IdDecoder(decodingKey);
   Person person = decoder.decode(scanResult);
   // Person.getId(); Person.getName(); ...

Android
-------

Include the jitpack_ repository in your global ``build.gradle``:

.. _jitpack: https://jitpack.io

.. code-block:: groovy

   allprojects {
       repositories {
           jcenter()
           maven { url "https://jitpack.io" }
       }
   }

Add the following dependency to your app ``build.gradle``:

.. code-block:: groovy

   dependencies {
       // ...
       // CRID Decoder
       compile 'io.kuralabs:crid-decoder:0.2.1'
   }


Compiling the library
=====================

Build jar archive::

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

   Copyright (C) 2017-2019 KuraLabs S.R.L

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
