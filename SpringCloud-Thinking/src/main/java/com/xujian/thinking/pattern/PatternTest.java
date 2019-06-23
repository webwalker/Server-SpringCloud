package com.xujian.thinking.pattern;

import com.xujian.thinking.pattern.Behavioral.Chain.ConcreteHandler1;
import com.xujian.thinking.pattern.Behavioral.Chain.ConcreteHandler2;
import com.xujian.thinking.pattern.Behavioral.Chain.ConcreteHandler3;
import com.xujian.thinking.pattern.Behavioral.Chain.Handler;
import com.xujian.thinking.pattern.Behavioral.Command.Command;
import com.xujian.thinking.pattern.Behavioral.Command.ConcreteCommand;
import com.xujian.thinking.pattern.Behavioral.Command.Invoker;
import com.xujian.thinking.pattern.Behavioral.Command.Receiver;
import com.xujian.thinking.pattern.Behavioral.Interpreter.AbstractExpression;
import com.xujian.thinking.pattern.Behavioral.Interpreter.Context;
import com.xujian.thinking.pattern.Behavioral.Interpreter.NonterminalExpression;
import com.xujian.thinking.pattern.Behavioral.Interpreter.TerminalExpression;
import com.xujian.thinking.pattern.Behavioral.Iterator.ConcreteAggregate;
import com.xujian.thinking.pattern.Behavioral.Iterator.ConcreteIterator;
import com.xujian.thinking.pattern.Behavioral.Mediator.ConcreteColleague1;
import com.xujian.thinking.pattern.Behavioral.Mediator.ConcreteColleague2;
import com.xujian.thinking.pattern.Behavioral.Mediator.ConcreteMediator;
import com.xujian.thinking.pattern.Behavioral.Memento.Caretaker;
import com.xujian.thinking.pattern.Behavioral.Memento.Originator;
import com.xujian.thinking.pattern.Behavioral.Observer.ConcreteObserver;
import com.xujian.thinking.pattern.Behavioral.Observer.ConcreteSubject;
import com.xujian.thinking.pattern.Behavioral.State.ConcreteStateA;
import com.xujian.thinking.pattern.Behavioral.Strategy.ConcreteStrategyA;
import com.xujian.thinking.pattern.Behavioral.Strategy.ConcreteStrategyB;
import com.xujian.thinking.pattern.Behavioral.Strategy.ConcreteStrategyC;
import com.xujian.thinking.pattern.Behavioral.Template.AbstractClass;
import com.xujian.thinking.pattern.Behavioral.Template.ConcreteClassA;
import com.xujian.thinking.pattern.Behavioral.Template.ConcreteClassB;
import com.xujian.thinking.pattern.Behavioral.Visitor.*;
import com.xujian.thinking.pattern.Creational.AbstractFactory.AbstractFactory;
import com.xujian.thinking.pattern.Creational.AbstractFactory.Client;
import com.xujian.thinking.pattern.Creational.AbstractFactory.ConcreteFactory1;
import com.xujian.thinking.pattern.Creational.AbstractFactory.ConcreteFactory2;
import com.xujian.thinking.pattern.Creational.Builder.Builder;
import com.xujian.thinking.pattern.Creational.Builder.ConcreteBuilder1;
import com.xujian.thinking.pattern.Creational.Builder.ConcreteBuilder2;
import com.xujian.thinking.pattern.Creational.Builder.Director;
import com.xujian.thinking.pattern.Creational.Factory.ConcreteCreatorA;
import com.xujian.thinking.pattern.Creational.Factory.ConcreteCreatorB;
import com.xujian.thinking.pattern.Creational.Factory.Creator;
import com.xujian.thinking.pattern.Creational.Prototype.ConcretePrototype1;
import com.xujian.thinking.pattern.Creational.Prototype.ConcretePrototype2;
import com.xujian.thinking.pattern.Creational.Singleton.Singleton;
import com.xujian.thinking.pattern.Structural.Adapter.Adapter;
import com.xujian.thinking.pattern.Structural.Adapter.Target;
import com.xujian.thinking.pattern.Structural.Bridge.Abstraction;
import com.xujian.thinking.pattern.Structural.Bridge.ConcreteImplementorA;
import com.xujian.thinking.pattern.Structural.Bridge.ConcreteImplementorB;
import com.xujian.thinking.pattern.Structural.Bridge.RefinedAbstraction;
import com.xujian.thinking.pattern.Structural.Composite.Composite;
import com.xujian.thinking.pattern.Structural.Composite.Leaf;
import com.xujian.thinking.pattern.Structural.Decorator.ConcreteComponent;
import com.xujian.thinking.pattern.Structural.Decorator.ConcreteDecoratorA;
import com.xujian.thinking.pattern.Structural.Decorator.ConcreteDecoratorB;
import com.xujian.thinking.pattern.Structural.Facade.Facade;
import com.xujian.thinking.pattern.Structural.Flyweight.Flyweight;
import com.xujian.thinking.pattern.Structural.Flyweight.FlyweightFactory;
import com.xujian.thinking.pattern.Structural.Flyweight.UnsharedConcreteFlyweight;
import com.xujian.thinking.pattern.Structural.Proxy.Proxy;

import java.util.ArrayList;

/**
 * @author xujian
 */
public class PatternTest {
    // / <summary>
    // / 责任链模式：
    // / 解除请求的发送者和接收者之间的耦合，而使多个对象有机会处
    // / 理这个请求。将这些请求连成一个链，并沿着这条链传递该请求，直到有个对象处理它。
    // / </summary>
    void Chain() {
        // Setup Chain of Responsibility
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        Handler h3 = new ConcreteHandler3();
        h1.SetSuccessor(h2);
        h2.SetSuccessor(h3);

        // Generate and process request
        int[] requests = {2, 5, 14, 22, 18, 3, 27, 20};

        for (int request : requests) {
            h1.HandleRequest(request);
        }
    }

    // / <summary>
    // / 命令模式：
    // / 将一个请求封装为一个对象，从而使你可以用不同的请求对客户进行参数化
    // / 对请求排队或记录请求日志，以及支持可以取消的操作
    // / </summary>
    void Command() {
        // Create receiver, command, and invoker
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();

        // Set and execute command
        invoker.SetCommand(command);
        invoker.ExecuteCommand();
    }

    // / <summary>
    // / 解释器模式：
    // / 给定一个语言，定义它的文法的一种表示，并定义一个解释器用于解释特定文法
    // / </summary>
    void Interpreter() {
        Context context = new Context();

        // Usually a tree
        ArrayList<AbstractExpression> list = new ArrayList<AbstractExpression>();

        // Populate 'abstract syntax tree'
        list.add(new TerminalExpression());
        list.add(new NonterminalExpression());
        list.add(new TerminalExpression());
        list.add(new TerminalExpression());

        // Interpret
        for (AbstractExpression exp : list) {
            exp.Interpret(context);
        }
    }

    // / <summary>
    // / 迭代子模式：
    // / 提供一种方法顺序访问一个聚合对象中的各种元素，而无需暴露该对象的内部表示
    // / </summary>
    void Iterator() {
        ConcreteAggregate a = new ConcreteAggregate();
        a.setItems(0, "Item A");
        a.setItems(1, "Item B");
        a.setItems(2, "Item C");
        a.setItems(3, "Item D");

        // Create Iterator and provide aggregate
        ConcreteIterator i = new ConcreteIterator(a);

        System.out.println("Iterating over collection:");

        Object item = i.First();
        while (item != null) {
            System.out.println(item);
            item = i.Next();
        }
    }

    // / <summary>
    // / 调停者模式：
    // / 用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式相互引用，
    // / 从而使得耦合松散，可以独立改变相互之间的交互
    // / </summary>
    void Mediator() {
        ConcreteMediator m = new ConcreteMediator();

        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);

        m.setColleague1(c1);
        m.setColleague2(c2);

        c1.Send("How are you?");
        c2.Send("Fine, thanks");
    }

    // / <summary>
    // / 备忘录模式：
    // / 不破坏封装的前提下，捕获对象的内部状态，并在该对象之外保存这个状态
    // / </summary>
    void Memento() {
        Originator o = new Originator();
        o.setState("On");

        // Store internal state
        Caretaker c = new Caretaker();
        c.setMemento(o.CreateMemento());

        // Continue changing originator
        o.setState("Off");

        // Restore saved state
        o.SetMemento(c.getMemento());
    }

    // / <summary>
    // / 观察者模式：
    // / 定义对象间的一种一对多的依赖关系，
    // / 以便当一个对象的状态发生变化时依赖于它的所有的对象都得到通知和刷新
    // / </summary>
    void Observer() {
        // Configure Observer pattern
        ConcreteSubject s = new ConcreteSubject();

        s.Attach(new ConcreteObserver(s, "X"));
        s.Attach(new ConcreteObserver(s, "Y"));
        s.Attach(new ConcreteObserver(s, "Z"));

        // Change subject and notify observers
        s.setSubjectState("ABC");
        s.Notify();
    }

    // / <summary>
    // / 状态模式：
    // / 允许一个对象再内部状态改变的时候改变它的行为。对象看起来似乎修改了所属的类。
    // / </summary>
    void State() {
        // Setup context in a state

        com.xujian.thinking.pattern.Behavioral.State.Context c = new com.xujian.thinking.pattern.Behavioral.State.Context(
                new ConcreteStateA());

        // Issue requests, which toggles state
        c.Request();
        c.Request();
        c.Request();
        c.Request();
    }

    // / <summary>
    // / 策略模式：
    // / 定义一系列的算法，把他们封装起来，并可以相互替换，使算法独立于客户
    // / </summary>
    void Strategy() {

        com.xujian.thinking.pattern.Behavioral.Strategy.Context context;

        // Three contexts following different strategies
        context = new com.xujian.thinking.pattern.Behavioral.Strategy.Context(
                new ConcreteStrategyA());
        context.ContextInterface();

        context = new com.xujian.thinking.pattern.Behavioral.Strategy.Context(
                new ConcreteStrategyB());
        context.ContextInterface();

        context = new com.xujian.thinking.pattern.Behavioral.Strategy.Context(
                new ConcreteStrategyC());
        context.ContextInterface();
    }

    // / <summary>
    // / 模板方法模式：
    // / 定义一个操作中的算法骨架，而将这些算法的具体实现的代码延迟到子类中完成
    // / </summary>
    void Template() {
        AbstractClass c;

        c = new ConcreteClassA();
        c.TemplateMethod();

        c = new ConcreteClassB();
        c.TemplateMethod();
    }

    // / <summary>
    // / 访问者模式：
    // / 识一个作用于某对象结构中的各元素的操作，
    // / 在不改变各元素的类的前提下定义作用于这个元素的新操作
    // / </summary>
    void Visitor() {
        // Setup structure
        ObjectStructure o = new ObjectStructure();
        o.Attach(new ConcreteElementA());
        o.Attach(new ConcreteElementB());

        // Create visitor objects
        ConcreteVisitor1 v1 = new ConcreteVisitor1();
        ConcreteVisitor2 v2 = new ConcreteVisitor2();

        // Structure accepting visitors
        o.Accept(v1);
        o.Accept(v2);
    }

    // Creational

    // / <summary>
    // / 工厂模式：
    // / 客户类和工厂类分开。消费者任何时候需要某种产品，只需向工厂请求即可。
    // / 消费者无须修改就可以接纳新产品。缺点是当产品修改时，工厂类也要做相应的修改。
    // / 如：如何创建及如何向客户端提供。
    // / </summary>
    void AbstractFactory() {
        // Abstract factory #1
        AbstractFactory factory1 = new ConcreteFactory1();
        Client client1 = new Client(factory1);
        client1.Run();

        // Abstract factory #2
        AbstractFactory factory2 = new ConcreteFactory2();
        Client client2 = new Client(factory2);
        client2.Run();
    }

    // / <summary>
    // / 建造者模式：一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
    // / </summary>
    void Builder() {
        // Create director and builders
        Director director = new Director();

        Builder b1 = new ConcreteBuilder1();
        Builder b2 = new ConcreteBuilder2();

        // Construct two products
        director.Construct(b1);

        com.xujian.thinking.pattern.Creational.Builder.Product p1 = b1.GetResult();
        p1.Show();

        director.Construct(b2);
        com.xujian.thinking.pattern.Creational.Builder.Product p2 = b2.GetResult();
        p2.Show();
    }

    // / <summary>
    // / 工厂方法模式：
    // / 定义一个用于创建对象的接口，让子类决定将哪一个类实例化。
    // / Factory Method让一个类的实例化延迟到子类
    // / </summary>
    void Factory() {
        // An array of creators
        Creator[] creators = new Creator[2];
        creators[0] = new ConcreteCreatorA();
        creators[1] = new ConcreteCreatorB();

        // Iterate over creators and create products
        for (Creator creator : creators) {
            com.xujian.thinking.pattern.Creational.Factory.Product product = creator
                    .FactoryMethod();
            System.out.println("Created " + product.getClass().getName());
        }
    }

    // / <summary>
    // / 原始模型模式：
    // / 用原型实例指定创建对象的种类，并且通过拷贝这个原型来创建新的对象
    // / </summary>
    void Prototype() {
        // Create two instances and clone each

        ConcretePrototype1 p1 = new ConcretePrototype1("I");
        ConcretePrototype1 c1 = (ConcretePrototype1) p1.Clone();
        System.out.println("Cloned: " + c1.getId());

        ConcretePrototype2 p2 = new ConcretePrototype2("II");
        ConcretePrototype2 c2 = (ConcretePrototype2) p2.Clone();
        System.out.println("Cloned: " + c2.getId());
    }

    // / <summary>
    // / 单例模式：
    // / 保证一个类仅有一个实例，并提供一个访问它的全局点。
    // / </summary>
    void Single() {
        // Constructor is protected -- cannot use new
        Singleton s1 = Singleton.Instance();
        Singleton s2 = Singleton.Instance();

        if (s1 == s2) {
            System.out.println("Objects are the same instance");
        }
    }

    // Structural

    // / <summary>
    // / 适配器模式：
    // / 将一个类的接口转换成客户希望的另一个接口，
    // / 使得原来由于接口不兼容而不能一起工作的那些类可以一起工作
    // / </summary>
    void Adapter() {
        Target target = new Adapter();
        target.Request();
    }

    // / <summary>
    // / 桥梁模式：将抽象部分与它的实现部分分离，使之可以独立变化
    // / </summary>
    void Bridge() {
        Abstraction ab = new RefinedAbstraction();

        // Set implementation and call
        ab.setImplementor(new ConcreteImplementorA());
        ab.Operation();

        // Change implemention and call
        ab.setImplementor(new ConcreteImplementorB());
        ab.Operation();
    }

    // / <summary>
    // / 合成模式：
    // / 将对象组合成树形结构以表示“部分－整体”的层次结构。
    // / Composite使得客户对单个对象和复合对象的使用具有一致性
    // / </summary>
    void Composite() {
        // Create a tree structure
        Composite root = new Composite("root");
        root.Add(new Leaf("Leaf A"));
        root.Add(new Leaf("Leaf B"));

        Composite comp = new Composite("Composite X");
        comp.Add(new Leaf("Leaf XA"));
        comp.Add(new Leaf("Leaf XB"));

        root.Add(comp);
        root.Add(new Leaf("Leaf C"));

        // Add and remove a leaf
        Leaf leaf = new Leaf("Leaf D");
        root.Add(leaf);
        root.Remove(leaf);

        // Recursively display tree
        root.Display(1);
    }

    // / <summary>
    // / 装饰模式：
    // / 动态地给一个对象添加一些额外的职责。
    // / 就扩展功能而言，Decorator模式比生成子类方式更加灵活
    // / </summary>
    void Decorator() {
        // Create ConcreteComponent and two Decorators
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorB d2 = new ConcreteDecoratorB();

        // Link decorators
        d1.SetComponent(c);
        d2.SetComponent(d1);

        d2.Operation();
    }

    // / <summary>
    // / 外观模式：
    // / 为子系统中的一组接口提供一个一致的界面，
    // / Facade模式定义了一个高层接口，使得这个子系统更加容易使用
    // / </summary>
    void Facade() {
        Facade facade = new Facade();

        facade.MethodA();
        facade.MethodB();
    }

    // / <summary>
    // / 享元模式：
    // / 运用共享技术有效的支持大量细粒度的对象
    // / </summary>
    void Flyweight() {
        // Arbitrary extrinsic state
        int extrinsicstate = 22;

        FlyweightFactory factory = new FlyweightFactory();

        // Work with different flyweight instances
        Flyweight fx = factory.GetFlyweight("X");
        fx.Operation(--extrinsicstate);

        Flyweight fy = factory.GetFlyweight("Y");
        fy.Operation(--extrinsicstate);

        Flyweight fz = factory.GetFlyweight("Z");
        fz.Operation(--extrinsicstate);

        UnsharedConcreteFlyweight fu = new UnsharedConcreteFlyweight();

        fu.Operation(--extrinsicstate);
    }

    // / <summary>
    // / 代理模式：
    // / 为其他对象提供一个代理以控制对这个对象的访问
    // / </summary>
    void Proxy() {
        // Create proxy and request a server
        Proxy proxy = new Proxy();
        proxy.Request();
    }
}