# SpringSampleProjects
Sample Projects related to Spring Basics


Spring-Solr Project:

Steps to build and run the application :

1. Need to download the Solr from Apache Website and extract it .
2. Open cmd and move to the   <Path to location of solr Extraction>solr-6.6.0\solr-6.6.0\bin
3. Type the command solr start byDefault it will start on port 8983 
4. You can cross check it by going to browser for location http://localhost:8983/solr
5. Create a core from cmd type : solr create -c "product"
6. Check on the Solr UI and check core exists or not .
7. Now you are ready to go just import the project and run SpringSolrApplication as java application 
8. You can cross check by going to Core product and run the query.:)

Spring Elastic Serach Project:

1. It is built to just show the basic example of elastic search using flat file to store indexes and search criteria .
2. I will update it later so that it will work for cluster mode .
