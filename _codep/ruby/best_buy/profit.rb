Profit = Class.new do
    def initialize(prices)
        @prices = prices
    end

    def get_max_profit
        max_profit = 0
        min_price = -1
        @prices.each do |p|
            if p < min_price || min_price == -1
                min_price = p
            elsif p - min_price > max_profit
                max_profit = p - min_price
            end
        end
        return max_profit
    end
end

