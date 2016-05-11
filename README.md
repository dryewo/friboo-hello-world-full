# Friboo Hello World Full

Example project featuring all [Friboo](https://github.com/zalando-stups/friboo) components.

## Roadmap

We want to make this possible:

```
lein new friboo my-new-project <OPTIONS>
```

OPTIONS are optional and compatible with each other:

* +api (based on [swagger1st](https://github.com/sarnowski/swagger1st))
* +db (PostgreSQL)
* +midje (to replace clojure.test, which is the default)
* +oauth2-tokens (based on [tokens](https://github.com/zalando-stups/tokens))
* +cron

? How do we enable UI? Should it be a API-like component that responds with HTML?

logging setup (by default DEBUG is not shown for project namespaces)

[Friboo] make a PR with wrap-handler to friboo

? [Friboo] Separate HTTP and API components

? [Friboo] Use namespaced keywords for system components (:mgmt-http, :metrics, :audit-log)
 
? Add database creation as the 0th migration step

## Credits

Based on [Essentials](https://github.com/zalando-stups/essentials) code.
