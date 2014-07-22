doxia-editing
=============

A simple Jahia module that integrates with Maven Doxia library to add support for editing using the APT or Markdown text formats

Status
------

- For the moment this module only contains a test case that tests the conversion of APT and Markdown files to HTML and
extracts the contents of the <body> tag of the generated HTML for future inclusion into existing pages

Todo
----
- A JSP function that renders the converted HTML
- A content definition for storing the APT or Markdown source
- A simple view to edit the content using a basic textarea (in live mode and with proper permissions)
- An action called on save to generate the conversion, to avoid doing it on render
- Integration with other modules such as blog, etc... 
