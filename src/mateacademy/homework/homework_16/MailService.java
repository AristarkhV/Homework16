package mateacademy.homework.homework_16;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MessageInterface<T>>{
    private Map<String, List<T>> mailBox = new HashMap<>(){
        @Override
        public List<T> get(Object key) {
            List<T> emptyList = Collections.emptyList();
            return getOrDefault(key, emptyList);
        }
    };

    @Override
    public void accept(MessageInterface<T> messageInterface) throws NullPointerException{
        String sendTo = messageInterface.getTo();
        if (!mailBox.containsKey(sendTo)){
            mailBox.put(sendTo, new LinkedList<>());
        }
        mailBox.get(sendTo).add(messageInterface.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return this.mailBox;
    }
}
