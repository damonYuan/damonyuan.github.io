BinarySearch = Class.new do
    class << self
        def search(arr, key)
            min = 0
            max = arr.size - 1
            while min <= max
                mid = min + (max - min)/2
                if key < arr[mid]
                    max = mid - 1
                elsif key > arr[mid]
                    min = mid + 1
                else
                    return mid
                end
            end
            return -1
        end
    end
end

# test
ar = [23, 45, 67, 89, 123, 568]
ar.sort
p BinarySearch.search(ar, 23)
p BinarySearch.search(ar, 89)
