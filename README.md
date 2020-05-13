# covid
Aplikacja prezentująca aktualną liczbę zakażonych Sars-Cov-2. <br />
Dane pobierane są ze strony https://www.gov.pl/web/koronawirus/wykaz-zarazen-koronawirusem-sars-cov-2, dzięki przetworzeniu pliku html strony.


##### Clone source code from git
```
git clone https://github.com/ntmichal/covid.git .
```

##### Build Docker image
```
docker build -t covid .
```
##### Run Docker Container
```
docker run -p 8080:8080 -it --rm covid:latest
```

<br />
Aplikacja wykorzystuje:
<ul>
  <li>SpringBoot</li>
  <li>Jsoup</li>
  <li>FasterXML/Jackson</li>
</ul>
<br />

https://covid19pl.herokuapp.com/
