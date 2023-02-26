# webflux

webflux는 reactive streams 라는 라이브러리를 구현하는 구현체로

stream을 활용하여 즉각적인 응답을 제공하고
(요청 이후 응답까지 잠깐의 시간이 걸리는데 이를 막연히 기다리는 것이 아닌 시간이 얼마정도 걸리는지
즉각적으로 통보하여 다른 요청을 받을 수 있게 하고 기존 요청은 이벤트 루프에 저장하여 비동기적으로 처리)

지속적인 통신을 통해 계속 서버로부터 응답을 받는다.
(SSE 프로토콜: Server Send Event 프로토콜로 push 기술을 이용해 서버가 주도적으로 응답하는 방식)
