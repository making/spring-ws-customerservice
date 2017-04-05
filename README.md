# Spring WS SOAP Service from existing WSDL

This sample shows how to configure the project to produce SOAP Web service using Spring Web Services from existing WSDL ([CustomerService.wsdl](http://cxf.apache.org/docs/defining-contract-first-webservices-with-wsdl-generation-from-java.data/CustomerService.wsdl) of [Apache CXF's example](http://cxf.apache.org/docs/defining-contract-first-webservices-with-wsdl-generation-from-java.html)).

If you prefer JSR-310, check [jsr-310](tree/jsr-310) branch.

## Generate sources

To generate sources from WSDL, run the following command:

```
./mvnw generate-sources
```

## Send a request

```
./mvnw spring-boot:run
```



```
curl -H 'Content-Type: text/xml' -d @request.xml http://localhost:9090
```

You'll receive (not formatted):

``` xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns3:getCustomersByNameResponse xmlns:ns3="http://customerservice.example.com/">
            <return>
                <name>maki</name>
                <numOrders>0</numOrders>
                <revenue>10000.0</revenue>
                <test>0</test>
                <type>BUSINESS</type>
            </return>
        </ns3:getCustomersByNameResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```