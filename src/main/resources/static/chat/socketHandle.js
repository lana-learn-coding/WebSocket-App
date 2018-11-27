var socket = new SockJS("/app/chat");
var stompClient = Stomp.over(socket);

function connect(func) {
    stompClient.connect({}, () => {
        func();
    });
}

function disconect(func) {
    stompClient.disconnect(() => {
        func();
    })
}

function send(message) {
    if (message instanceof Message) {
        stompClient.send("/app/" + message.group, {}, message.toString());
    }
}

function subscribe(groupId, func) {
    //TODO: check if group exist
    stompClient.subscribe("/group/" + groupId, (response) => {
        if (func != null) {
            func(response);
        }
    })
}

function unsubscribe(groupId, func) {
    stompClient.unsubscribe("/group/" + groupId, (response) => {
        if (func != null) {
            func(response)
        }
    })
}

