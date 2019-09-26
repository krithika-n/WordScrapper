# Word Scrapper

Hi! I'm your first Markdown file.

# How to run
In the directory where the jar file is

        java -jar <jar file> <url to be scrapped>

URL should always be pefixed with "http://"

For example


         java -jar mavenHello.jar "https://sherlock-holm.es/stories/html/five.html"

# Deliverables
1.  Jar File
2.  Unit Tests
3.  Project Code (Zipped)
4.  Documentation 
5.  Read_Me file

# Assumptions
- Dynamically loaded content is ignored
- All non-english content is ignored
- Punctuation and stop words as specified in Stanford NLP are ignored
- When two words have similar count, the order in which they are retrieved is not constant.
- If there are 4 words with the highest count, they are retrieved as the first 4 words.
	-Eg: if "apple", "candy", "caramel" are all mentioned 48 times, the output will be
	1. apple
	2. caramel
	3. candy
	4. and so on..
	i.e the top 25 words are retrieved rather than the top 25 counts.
- If there are more than one word with the 25th largest count, any one of them is retrieved and others are ignored, assuming there is only one word for each count value in the previous 24 instances
- Order of output for the same file may be different each time the program is run, if there are multiple words with the same count.
- Lemmatizing using Stanford NLP sometimes produces words which aren't in dictionary

# Future Extensions
- Make the sorting stable
- Retrieve top K words instead of always top 25
- More extensive unit tests
- More robust for Lemmatization and stemming of words to prevent non-dictionary words
- Use a dictionary checking mechanism to check the processed words
- Tag filtering on HTML tags to ignore content from certain tags
- GUI interface or web app with REST API endpoints

# Documentation

Documentation is under the project-folder/out/Documentation/index.html

# Dependencies

- org:jsoup:jsoup:1.12.1:jsoup-1.12.1.jar
- edu:stanford:nlp:stanford-corenlp:3.9.2:stanford-corenlp-3.9.2.jar
- com:apple:AppleJavaExtensions:1.4:AppleJavaExtensions-1.4.jar
- de:jollyday:jollyday:0.4.9:jollyday-0.4.9.jar
- org:apache:commons:commons-lang3:3.3.1:commons-lang3-3.3.1.jar
- org:apache:lucene:lucene-queryparser:4.10.3:lucene-queryparser-4.10.3.jar
- org:apache:lucene:lucene-sandbox:4.10.3:lucene-sandbox-4.10.3.jar
- org:apache:lucene:lucene-analyzers-common:4.10.3:lucene-analyzers-common-4.10.3.jar
- org:apache:lucene:lucene-queries:4.10.3:lucene-queries-4.10.3.jar
- org:apache:lucene:lucene-core:4.10.3:lucene-core-4.10.3.jar
- javax:servlet:javax.servlet-api:3.0.1:javax.servlet-api-3.0.1.jar
- com:io7m:xom:xom:1.2.10:xom-1.2.10.jar
- xml-apis:xml-apis:1.3.03:xml-apis-1.3.03.jar
- xerces:xercesImpl:2.8.0:xercesImpl-2.8.0.jar
- xalan:xalan:2.7.0:xalan-2.7.0.jar
- joda-time:joda-time:2.9.4:joda-time-2.9.4.jar
- com:googlecode:efficient-java-matrix-library:ejml:0.23:ejml-0.23.jar
- org:glassfish:javax.json:1.0.4:javax.json-1.0.4.jar
- com:google:protobuf:protobuf-java:3.2.0:protobuf-java-3.2.0.jar
- javax:activation:javax.activation-api:1.2.0:javax.activation-api-1.2.0.jar
- javax:xml:bind:jaxb-api:2.4.0-b180830.0359:jaxb-api-2.4.0-b180830.0359.jar
- com:sun:xml:bind:jaxb-core:2.3.0.1:jaxb-core-2.3.0.1.jar
- com:sun:xml:bind:jaxb-impl:2.4.0-b180830.0438:jaxb-impl-2.4.0-b180830.0438.jar
- edu:stanford:nlp:stanford-corenlp:3.9.2:stanford-corenlp-3.9.2-models.jar
- org:slf4j:slf4j-api:1.7.5:slf4j-api-1.7.5.jar
- org:slf4j:slf4j-log4j12:1.7.5:slf4j-log4j12-1.7.5.jar
- log4j:log4j:1.2.17:log4j-1.2.17.jar
- org:junit:jupiter:junit-jupiter-api:5.4.2:junit-jupiter-api-5.4.2.jar
- org:apiguardian:apiguardian-api:1.0.0:apiguardian-api-1.0.0.jar
- org:opentest4j:opentest4j:1.1.1:opentest4j-1.1.1.jar
- org:junit:platform:junit-platform-commons:1.4.2:junit-platform-commons-1.4.2.jar
- org:junit:jupiter:junit-jupiter-engine:5.4.2:junit-jupiter-engine-5.4.2.jar
- org:junit:platform:junit-platform-engine:1.4.2:junit-platform-engine-1.4.2.jar

