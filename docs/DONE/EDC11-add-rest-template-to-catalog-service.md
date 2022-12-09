We want to integrate rest template to communicate between rating and info microservices

To integrate that, we need to:
- create a RestClientConfig class
- autowire RestTemplate to the Service Constructor
- use requests to do the logic in each Service