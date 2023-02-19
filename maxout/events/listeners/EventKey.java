package maxout.events.listeners;

import maxout.events.Event;

public class EventKey extends Event<EventKey>
{
  public int code;
  
  public EventKey(int code) {
    this.code = code;
  }
}
