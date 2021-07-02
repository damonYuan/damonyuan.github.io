require './profit.rb'

BestBuy = Class.new do
    class << self
        def test
            price1 = [7, 1, 5, 3, 6, 4]
            price2 = [7, 6, 4, 3, 1]
            profit = Profit.new price1 
            puts profit.get_max_profit
            profit = Profit.new price2
            puts profit.get_max_profit
        end
    end
end

BestBuy.test
