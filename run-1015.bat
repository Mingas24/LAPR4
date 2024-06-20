
openssl req -new -x509 -days 3650 -nodes -sha256 -out client.pem -keyout client.key

openssl pkcs12 -export -in client.pem -inkey client.key -out client.p12 -name client -passin pass:lapr2020 -passout pass:lapr2020

keytool -importkeystore -srckeystore client.p12 -srcstoretype PKCS12 -srcstorepass lapr2020 -alias client -deststorepass lapr2020 -destkeypass lapr2020 -destkeystore client-keystore.jks

keytool -genkey -v -alias server -keyalg RSA -keysize 2048 -validity 365 -keystore server.jks -storepass lapr2020

keytool -exportcert -alias server -keystore server.jks -storepass lapr2020 -rfc -file server.pem

keytool -import -alias client -keystore server.jks -file client.pem -storepass lapr2020

keytool -import -alias server -keystore client-keystore.jks -file server.pem -storepass lapr2020