class Message {
    constructor(group, username, content) {
        this.id = null;
        this.content = content;
        this.group = group;
        this.username = username;
    }

    toString() {
        return JSON.stringify(this);
    }

    static parse(jsonObject) {
        let message = new Message(
            jsonObject.username,
            jsonObject.content,
            jsonObject.group,
        );
        message.id = jsonObject.id;
        return message;
    }
}

class Group {
    constructor(name) {
        this.id = null;
        this.name = name;
    }

    toString() {
        return JSON.stringify(this);
    }

    static parse(jsonObject) {
        let group = new Group(jsonObject.name);
        group.id = jsonObject.id;
        return group;
    }
}