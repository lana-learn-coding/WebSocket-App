$(() => {
    let userId = $("#userId").text();
    connect(() => {
            subscribe(1, (response) => {
                let body = JSON.parse(response.body);
                let msg = Message.parse(body);
                let user = User.parse(body.user);
                $("#chatRoom").append("<p><b style='color:blue;'>" + user.username +
                    ": </b>" + msg.content + "</p>");
                $("#chatRoom").css().width("100%");

            });
            send(new Message("Joined !", userId, "1"))
        }
    );
    $("#send").click(() => {
        let msg = $("#chatBox").val();
        send(new Message(msg, userId, "1"));
    })
});