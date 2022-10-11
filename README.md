# Ultimate Super Jett Library
Yeah no, don't actually use this for your library

## Programming steps
- [ ] Jetty webapp that serves a React app
  - [ ] Jetty that serves content from /webapp
    - [x] Start a server with Jetty
    - [x] Serve a static page
    - [ ] Serve a servlet that returns a book
    - [ ] Serve an api endpoint that returns a book in JSON format
    - [ ] Introduce JAX-RS to serve a GET resource with jersey ServletContainer
    - [ ] Use JAX-R to serve a POST resource
  - [ ] React app that allows for uploading a book title and get a book list
    - [ ] Set up a React project with Vite
    - [ ] Configure Vite to build to /webapp
    - [ ] Configure server to not lock /webapp resources while serving
    - [ ] Configure maven to run npm build before packaging
  - [ ] Add GitHub actions to test code on push to main
  - [ ] Deploy to Azure