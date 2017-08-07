# lex-boot
A reference implementation of a Bot Application using Amazon Lex for NLP.
It currently uses AWS SDK although just consuming the Rest API would be more scalable in terms of updating to newer versions & to keep our implementation more independent of the underlying NLP platform. The sdk also makes calls to the lex rest endpoints.


To Setup on Local:-

docker run --name mysqltestcont -e MYSQL_ROOT_PASSWORD=Password0 -e MYSQL_DATABASE=mylexdb -p 3306:3306  mysql:5.7

mvn clean install

Run the application “LexBootApplication” (starts on default tomcat 8080)

A sample chat to interact with the Bot : http://localhost:8080/ 

If required, run the Integration Tests to train the bot with custom intents, slots & utterances.(Incomplete so not committed yet)

Note:- The AWS auth provider currently used is ProfileCredentialsProvider which relays on the associated AWS Credentials that were used to login to AWS (CLI) on the local system. As it reads from the environment.

Postman collection:
https://ifactor.postman.co/docs/collection/view/2397070-4e675880-3139-0fe1-b54d-0da98e586bf9 


*****
I'm also working on building a ref impl for Google's Api.ai platform. The best way to compare these platforms is by training the models with a lot of data. In order to do that we can write some Integration Tests to do everything from Building the bot, intents, entities, utterances, prompts etc. inaccordance to our conversational flows and use them to train the models. 

https://aws.amazon.com/lex/pricing/ vs https://api.ai/pricing/ (Although api.ai is free, It was mentioned somewhere that restrictions may apply on bandwidth i.e. requests/sec)

I tried to simulate two flows "Register for Notifications" & "Bill payment" where both the platforms had very similar accuracy till now with a small sample set of data. If we have some of this data archived somewhere we could probably train the models with larger data sets.

In comparison with Lex, the Api.ai seems a bit more evolved with additional features - defining "contextual" converation flows is probably the most important distinction. Others include support for Small Talk, Rich messaging support, Easier integrations with several messaging channels. 





