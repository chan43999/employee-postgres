from openjdk

COPY ./build/libs .

CMD java -jar *.jar