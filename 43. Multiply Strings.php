<?php
/**
 * Created by PhpStorm.
 * User: liu
 * Date: 2019-02-15
 * Time: 22:58
 */
class Solution {

	/**
	 * @param String $num1
	 * @param String $num2
	 * @return String
	 */
	function multiply($num1, $num2) {
		$int1 = new BigInt();
		$int2 = new BigInt();
		$int1->initFromString($num1);
		$int2->initFromString($num2);
		return $int1->multiply($int2)->__toString();
	}
}

class BigInt
{
	public $bits = [];

	public function initFromString(string $num)
	{
		$len = strlen($num);
		$start = true;
		for ($i = 0; $i < $len; $i++) {
			$v = (int)$num[$i];
			if ($start && $v === 0) {
				continue;
			}
			$start = false;
			$this->bits[] = $v;
		}
		$this->bits = array_reverse($this->bits);
	}

	public function __toString()
	{
		while ($this->bits[count($this->bits)-1] === 0) {
			unset($this->bits[count($this->bits)-1]);
		}
		if (empty($this->bits)) {
			return '0';
		}
		return implode('', array_reverse($this->bits));
	}

	public function multiply(BigInt $int2)
	{
		$bits = [];
		$len1 = count($this->bits);
		$len2 = count($int2->bits);
		for ($i = 0; $i < $len1; $i++) {
			for ($j = 0; $j < $len2; $j++) {
				if (!isset($bits[$i + $j])) {
					$bits[$i + $j] = 0;
				}if (!isset($bits[$i + $j + 1])) {
					$bits[$i + $j + 1] = 0;
				}
				$bits[$i + $j] += $this->bits[$i] + $int2->bits[$j];
				$bits[$i + $j + 1] += (int)($bits[$i + $j] / 10);
				$bits[$i + $j] %= 10;
			}
		}
		$int3 = new static();
		$int3->bits = $bits;
		return $int3;
	}
}

$s = new Solution();
echo $s->multiply('9057773606324709', '6163425502208998467403686824111758192642092981940702060972385470482676197505902994313');
