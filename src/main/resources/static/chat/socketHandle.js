$(function () {
    let socket = new SockJS("/app/chat");
    let stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        stompClient.subscribe("/group/1", function (respone) {
            console.log(respone.body)
        });
        stompClient.send("/app/1", {}, new Message("hi", 1, 1).toString());
    });
});



