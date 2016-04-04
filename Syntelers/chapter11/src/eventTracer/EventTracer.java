package eventTracer;

import java.awt.*;
import java.beans.*;
import java.lang.reflect.*;

public class EventTracer {
	private InvocationHandler handler;

	private EventTracer() {
		// the handler for all event
		handler = new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) {
				System.out.println(method + ":" + args[0]);
				return null;
			}
		};
	}

	public void add(Component c) {
		try {
			BeanInfo info = Introspector.getBeanInfo(c.getClass());
			EventSetDescriptor[] eventSets = info.getEventSetDescriptors();
			for (EventSetDescriptor eventSet : eventSets)
				addListener(c, eventSet);
		} catch (IntrospectionException e) {
		}
		if (c instanceof Container) {
			// get all children and called recursively
			for (Component comp : ((Container) c).getComponents())
				add(comp);
		}
	}


	private void addListener(Component c, EventSetDescriptor eventSet) {
		Object proxy = Proxy.newProxyInstance(null, new Class[] { eventSet.getListenerType() }, handler);
		Method addListenerMethod = eventSet.getAddListenerMethod();
		try {
			addListenerMethod.invoke(c, proxy);
		} catch (ReflectiveOperationException e) {
		}
	}
}
