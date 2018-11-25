
class Message {
    constructor(group, username, content) {
        this.id = null;
        this.content = content;
        this.group = group;
        this.user = username;
    }

    toString() {
        return JSON.stringify(this);
    }

    static parse(jsonObject) {
        let message = new Message(
            jsonObject.user,
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

class User {
    constructor(username, password) {
        this.username = username;
        this.password = password || null;
        this.id = null;
    }

    toString() {
        return JSON.stringify(this);
    }

    static parse(jsonObject) {
        let user = new User();
        user.username = jsonObject.username;
        user.id = jsonObject.id;
        return user;
    }
}