Metaprogramming Ruby
=====

1. class_eval on instances !!
class_eval can only work on Class!
```
o = Object.new
o.instance_eval do 
  def test1 
    puts "test 1"
  end
end
```

equivalent to :
```
o = Object.new
o.singleton_class.class_eval do 
  def test2
    puts "test 2"
  end
end    