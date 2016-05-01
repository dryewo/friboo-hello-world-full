# Friboo Hello World Full

Example project featuring all [Friboo](https://github.com/zalando-stups/friboo) components.

## Roadmap

```
lein new friboo my-new-project <OPTIONS>
```

OPTIONS are optional and compatible with each other:

* +api 
* +db
* +midje (to replace clojure.test, which is the default)

? How do we enable we UI? Should it be a API-like component that responds with HTML?

logging setup (by default DEBUG is not shown for project namespaces)

[Friboo] make a PR with wrap-handler to friboo

? [Friboo] Separate HTTP and API components

? [Friboo] Use namespaced keywords for system components (:mgmt-http, :metrics, :audit-log) 

## Credits

Based on [Essentials](https://github.com/zalando-stups/essentials) code.
