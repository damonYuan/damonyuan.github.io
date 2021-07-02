class Permutations
    def initialize(arr) 
        @arr = arr
    end

    def show
        perm @arr
    end

    private
    def perm arr, i=0
        p arr if i == arr.size
        (i...arr.size).each do |j|
            arr[i], arr[j] = arr[j], arr[i]
            perm arr, i+1
            arr[i], arr[j] = arr[j], arr[i]
        end
    end
end

perm = Permutations.new('ABC')
perm.show
