let socket = new SockJS("/app/chat");
let stompClient = Stomp.over(socket);


stompClient.connect({},function () {
    stompClient.subscribe("/group/1", function (response) {
        let msg = JSON.parse(response.body);
        console.log(response);
    });
    let msg = new Message();
    msg.content="hello";
    msg.group = "1";
    msg.user = null;
    stompClient.send("/app/1", {}, msg);
});



