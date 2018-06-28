Changelog
---------
* 3.3.0
    * Implement Pylon Task API Support
    * Resolves #110; Add `id`, if supplied, to form for `updateOrCreate` in DatasiftManagedSources
* 3.2.16
    * Resolves Issue #108; swap HistoricsQueryList from implementing List to implementing Iterable, as ManagedSourceList does
* 3.2.15
    * Deprecate `foursq` parameter for Instagram -  They've removed this field from their API
    * adds the "id" param that was missing when making managed sources log requests
    * fix an issue where calling stop on pylon was missing a param
* v.3.2.14 upgrades HTTP client which now creates a custom thread pool so that all threads Netty created are daemons
    * This enables the client to shutdown when all non-daemon threads do
* v.3.2.13 makes the dead connection detection thread a deamon so a process terminates when all other threads do
* v.3.2.12
    * Pylon endpoints now take and return a recording ID, rather than a hash
    * Moved to v1.3 API

* v.3.2.10 Fixes a race condition in FutureData which resulted in the client blocking forever
* v.3.2.9 Adds [dependency convergence](https://maven.apache.org/enforcer/enforcer-rules/dependencyConvergence.html). Ensures only a single version of a library gets pulled in by the client and its dependencies. (2015-11-18)
* v.3.2.2 Adds support for Pylon analysis (2015-01-14)

* v.3.1.1 Fix to handle null connection on subscription (2014-10-08)

* v.3.1.0 Added support for multiple connections, and introduced configurable web socket host (2014-09-22)

* v.3.0.0 Complete upgrade, replacing old libraries, adding new features and addressing all previously known bugs.(2013-09-30)

1. Adds Netty, Higgs.IO and Boundary's maintained copy of the High scale lib by Cliff Click
2. Introduces an asyncronous API
3. Adds support for all DataSift APIs including Core, Historics, Push and managed sources

* v.2.2.1 Updates to WebSocket Library, APIClient uses SSL.(2013-04-22)

* v.2.2.0 Finalised support for Historics and addedsupport for Push
          delivery (2012-08-17)

* v.2.1.1 Fixed some bugs in the websocket reconnection logic (2012-07-26)

* Added the develop branch as required by git flow (2012-08-15)

* v.2.0.0 Added onConnect, onDisconnect and onStatus events, improved
          efficiency within the WebSocket library, and support for the
          historics API (2012-06-22). Please note: Though support has been
          added for the the Historics API, the API itself is not yet publicly
          available. Access will be made available over the coming months.

  The IStreamConsumerEvents and IMultiStreamConsumerEvents interfaces now
  contain callbacks for onConnect, onDisconnect and onStatus events. These
  MUST be implemented in your event handler.

* v.1.3.4 Added SSL support for HTTP streams (2012-05-15)

  This is enabled by default and can be disabled by passing false as the third
  parameter to the User constructor, or calling enableSSL(false) on the User
  object.

* v.1.3.3 Subscriptions are no longer lost on reconnection (2012-05-15)

* v.1.3.2 Added User-Agent header to the StreamConsumers (2012-03-13)

* v.1.3.1 Do not reconnect when a 4xx response is received (2012-03-08)

* v.1.3.0 Stream warning/error handling + WS disconnection changes (2012-03-08)

  The IStreamConsumerEvents and IMultiStreamConsumerEvents interfaces now
  contain callbacks for onWarning and onError events. These MUST be implemented
  in your event handler.

  The WebSocket consumer has been modified to request that the server
  unsubscribe from all streams and disconnect rather than simply closing
  the connection. This change is largely transparent except that you'll get
  an error notification acknowledging the request and indicating that the
  server is about to disconnect. The client will then wait up to 30 seconds
  for the server to actually disconnect before closing the socket itself. This
  should never happen as the server will usually disconnect immediately after
  sending that message.

* v.1.2.1 Clarification (2012-02-27)

  Modified the football example to display the IDs of interactions so you can
  visually match deletion notifications with the original tweet.

  NB: If you are using an implementation of IStreamConsumerEvents to handle
  events, you must implement the new onDeleted method or the code will throw
  an exception when a delete notification is received. The multi-stream
  equivalent, IMultiStreamConsumerEvents, also contains a new onDeleted
  method which must be implemented.

* v.1.2.0 Twitter Compliance (2012-02-26)

  The StreamConsumer now defines an onDeleted(Interaction interaction) method
  to handle DELETE requests from Twitter.
  (@see http://dev.datasift.com/docs/twitter-deletes)

  NB: You must implement this method in your code if you extend StreamConsumer.
