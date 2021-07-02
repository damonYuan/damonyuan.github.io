SqRoot = Class.new do
    def initialize(value, accuracy=0.0001, round=3)
       if value < 0
           raise "value should >= 0"
       end
       if accuracy <= 0
           raise "accuracy should > 0"
       end
       if round <= 0
           raise "round should > 0"
       end
       @value = value
       @accuracy = accuracy
       @round = round
    end

    def get_root
        _prev = 10
        _next = 10

        loop do 
            _prev = _next
            _next = (@value + _prev * _prev) / (2 * _prev)
            break if (_prev - _next).abs <  @accuracy
        end

        _next.round @round
    end
end


puts 'Enter a number: '
number = gets
sq_root = SqRoot.new(number.to_f)
puts "root of #{number} is #{sq_root.get_root}"
